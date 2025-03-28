package eksempler._15.memorabilia;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Inventory {
    private static final String ADD_POSTER_SQL = "INSERT INTO poster VALUES (?,?,?,?,?,?,?,?)";
    private static final String ADD_SKATEBOARD_SQL = "INSERT INTO skateboard VALUES (?,?,?,?,?,?,?)";
    private static final String ADD_SPORTEQUIPMENT_SQL = "INSERT INTO sportequipment VALUES (?,?,?,?,?,?,?)";
    private static final String GET_ALL_POSTERS_SQL = "SELECT id,name,year,celebrityInvolved,description,askingPrice,width,height FROM poster";
    private static final String GET_ALL_SKATEBOARDS_SQL = "SELECT id,name,year,celebrityInvolved,description,askingPrice,skateboardType FROM skateboard";
    private static final String GET_ALL_SPORTEQUIPMENTS_SQL = "SELECT id,name,year,celebrityInvolved,description,askingPrice,sport FROM sportequipment";

    private final MysqlDataSource memorabiliaDS;

    public Inventory() {
        this.memorabiliaDS = new MysqlDataSource();
        memorabiliaDS.setServerName(PropertiesProvider.PROPS.getProperty("host"));
        memorabiliaDS.setPortNumber(Integer.parseInt(PropertiesProvider.PROPS.getProperty("port")));
        memorabiliaDS.setDatabaseName(PropertiesProvider.PROPS.getProperty("db_name"));
        memorabiliaDS.setUser(PropertiesProvider.PROPS.getProperty("uname"));
        memorabiliaDS.setPassword(PropertiesProvider.PROPS.getProperty("pwd"));
    }

    public void insertPoster(Poster poster) throws SQLException {
        try (Connection con = memorabiliaDS.getConnection();
             PreparedStatement statement = con.prepareStatement(ADD_POSTER_SQL);
        ) {
            statement.setInt(1, poster.getId());
            statement.setString(2, poster.getName());
            statement.setInt(3, poster.getYear().getValue());
            statement.setString(4, poster.getCelebrityInvolved());
            statement.setString(5, poster.getDescription());
            statement.setInt(6, poster.getAskingPrice());
            statement.setInt(7, poster.getWidth());
            statement.setInt(8, poster.getHeight());
            statement.executeUpdate();
        }
    }

    public void insertSkateboard(Skateboard skateboard) throws SQLException {
        try (Connection con = memorabiliaDS.getConnection();
             PreparedStatement statement = con.prepareStatement(ADD_SKATEBOARD_SQL);
        ) {
            statement.setInt(1, skateboard.getId());
            statement.setString(2, skateboard.getName());
            statement.setInt(3, skateboard.getYear().getValue());
            statement.setString(4, skateboard.getCelebrityInvolved());
            statement.setString(5, skateboard.getDescription());
            statement.setInt(6, skateboard.getAskingPrice());
            statement.setString(7, skateboard.getSkateboardType());
            statement.executeUpdate();
        }
    }

    public void insertSportEquipment(SportEquipment sportEquipment) throws SQLException {
        try (Connection con = memorabiliaDS.getConnection();
             PreparedStatement statement = con.prepareStatement(ADD_SPORTEQUIPMENT_SQL);
        ) {
            statement.setInt(1, sportEquipment.getId());
            statement.setString(2, sportEquipment.getName());
            statement.setInt(3, sportEquipment.getYear().getValue());
            statement.setString(4, sportEquipment.getCelebrityInvolved());
            statement.setString(5, sportEquipment.getDescription());
            statement.setInt(6, sportEquipment.getAskingPrice());
            statement.setString(7, sportEquipment.getSport());
            statement.executeUpdate();
        }
    }

    public Set<Poster> getAllPosters() throws SQLException {
        Set<Poster> posters = new HashSet<>();
        try (Connection con = memorabiliaDS.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(GET_ALL_POSTERS_SQL);
        ) {
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Year year = Year.of(rs.getInt("year"));
                String celeb = rs.getString("celebrityInvolved");
                String description = rs.getString("description");
                int askingPrice = rs.getInt("askingPrice");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Poster poster = new Poster(id, name, year, celeb, description, askingPrice, width, height);
                posters.add(poster);
            }
        }
        return posters;
    }

    public Set<Skateboard> getAllSkateboards() throws SQLException {
        Set<Skateboard> skateboards = new HashSet<>();
        try (Connection con = memorabiliaDS.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(GET_ALL_SKATEBOARDS_SQL);
        ) {
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Year year = Year.of(rs.getInt("year"));
                String celeb = rs.getString("celebrityInvolved");
                String description = rs.getString("description");
                int askingPrice = rs.getInt("askingPrice");
                String type = rs.getString("skateboardType");
                Skateboard board = new Skateboard(id, name, year, celeb, description, askingPrice, type);
                skateboards.add(board);
            }
        }
        return skateboards;
    }

    public Set<SportEquipment> getAllSportEquipments() throws SQLException {
        Set<SportEquipment> sportEquipments = new HashSet<>();
        try (Connection con = memorabiliaDS.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(GET_ALL_SPORTEQUIPMENTS_SQL);
        ) {
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Year year = Year.of(rs.getInt("year"));
                String celeb = rs.getString("celebrityInvolved");
                String description = rs.getString("description");
                int askingPrice = rs.getInt("askingPrice");
                String sport = rs.getString("sport");
                SportEquipment se = new SportEquipment(id, name, year, celeb, description, askingPrice, sport);
                sportEquipments.add(se);
            }
        }
        return sportEquipments;
    }

    public Set<Memorabilia> getAllMemorabilia() throws SQLException {
        Set<Memorabilia> memorabilias = new HashSet<>();
        Set<SportEquipment> sportEquipments = getAllSportEquipments();
        memorabilias.addAll(sportEquipments);
        memorabilias.addAll(getAllPosters());
        memorabilias.addAll(getAllSkateboards());
        return memorabilias;
    }

    public void insertMemorabilia(Set<Memorabilia> allMemorabilia) throws SQLException {
        for (Memorabilia memorabilia : allMemorabilia) {
            if(memorabilia instanceof Skateboard){
                insertSkateboard((Skateboard)memorabilia);
            } else if(memorabilia instanceof SportEquipment){
                insertSportEquipment((SportEquipment) memorabilia);
            } else {
                insertPoster((Poster) memorabilia);
            }
        }
    }
}
