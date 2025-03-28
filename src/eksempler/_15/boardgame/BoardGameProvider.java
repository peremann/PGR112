package eksempler._15.boardgame;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static eksempler._15.boardgame.PropertiesProvider.PROPS;

public class BoardGameProvider {
    // You may consider having these SQL statements in a separate file.
    private static final String GET_ALL_BOARDGAMES_SQL = "SELECT brettspill_id, navn, type, antall_spillere, spilletid, aldersgrense, bilde FROM Brettspill";
    private static final String GET_BOARDGAME_SQL = "SELECT brettspill_id, navn, type, antall_spillere, spilletid, aldersgrense, bilde FROM Brettspill WHERE brettspill_id=?";
    private static final String ADD_BOARDGAME_SQL = "INSERT INTO Brettspill VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE_BOARDGAME_SQL = "UPDATE Brettspill SET navn=?, type=?, antall_spillere=?, spilletid=?, aldersgrense=?, bilde=? WHERE brettspill_id=?";
    private static final String DELETE_BOARDGAME_SQL = "DELETE FROM Brettspill WHERE brettspill_id =?";
    private final MysqlDataSource boardGameDS;

    public BoardGameProvider(){
        boardGameDS = new MysqlDataSource();
        boardGameDS.setServerName(PROPS.getProperty("host"));
        boardGameDS.setPortNumber(Integer.parseInt(PROPS.getProperty("port")));
        boardGameDS.setDatabaseName(PROPS.getProperty("db_name"));
        boardGameDS.setUser(PROPS.getProperty("uname"));
        boardGameDS.setPassword(PROPS.getProperty("pwd"));
    }

    public List<BoardGame> getBoardGames() throws SQLException {
        List<BoardGame> boardGames = new ArrayList<>();
        try (Connection con = boardGameDS.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(GET_ALL_BOARDGAMES_SQL);
        ) {
            while(rs.next()){
                int id = rs.getInt("brettspill_id");
                String name = rs.getString("navn");
                String type = rs.getString("type");
                int nrOfPlayers = rs.getInt("antall_spillere");
                int minutes = rs.getInt("spilletid");
                int ageLimit = rs.getInt("aldersgrense");
                String imageUrl = rs.getString("bilde");
                BoardGame bg = new BoardGame(id, name, type, nrOfPlayers, minutes, ageLimit, imageUrl);
                boardGames.add(bg);
            }
        }
        return boardGames;
    }

    public BoardGame getBoardGame(int boardGameId) throws SQLException {
        try (Connection con = boardGameDS.getConnection();
             PreparedStatement statement = con.prepareStatement(GET_BOARDGAME_SQL);
        ) {
            statement.setInt(1, boardGameId);
            try (ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    String name = rs.getString("navn");
                    String type = rs.getString("type");
                    int nrOfPlayers = rs.getInt("antall_spillere");
                    int minutes = rs.getInt("spilletid");
                    int ageLimit = rs.getInt("aldersgrense");
                    String imageUrl = rs.getString("bilde");
                    return new BoardGame(boardGameId, name, type, nrOfPlayers, minutes, ageLimit, imageUrl);
                }
            }
            // No board game found...
            return null; // We will look at other options than returning null later...
        }
    }

    public int addBoardGame(BoardGame bg) throws SQLException {
        try (Connection con = boardGameDS.getConnection();
             PreparedStatement statement = con.prepareStatement(ADD_BOARDGAME_SQL);
        ) {
            statement.setInt(1, bg.id());
            statement.setString(2, bg.name());
            statement.setString(3, bg.type());
            statement.setInt(4, bg.nrOfPlayers());
            statement.setInt(5, bg.minutes());
            statement.setInt(6, bg.ageLimit());
            statement.setString(7, bg.imageUrl());
            return statement.executeUpdate();
        }
    }

    public int updateBoardGame(BoardGame bg) throws SQLException {
        try (Connection con = boardGameDS.getConnection();
             PreparedStatement statement = con.prepareStatement(UPDATE_BOARDGAME_SQL);
        ) {
            statement.setString(1, bg.name());
            statement.setString(2, bg.type());
            statement.setInt(3, bg.nrOfPlayers());
            statement.setInt(4, bg.minutes());
            statement.setInt(5, bg.ageLimit());
            statement.setString(6, bg.imageUrl());
            statement.setInt(7, bg.id());
            return statement.executeUpdate();
        }
    }

    public int deleteBoardGame(int boardGameId) throws SQLException {
        try (Connection con = boardGameDS.getConnection();
             PreparedStatement statement = con.prepareStatement(DELETE_BOARDGAME_SQL);
        ) {
            statement.setInt(1, boardGameId);
            return statement.executeUpdate();
        }
    }
}
