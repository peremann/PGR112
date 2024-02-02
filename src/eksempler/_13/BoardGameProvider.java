package eksempler._13;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardGameProvider {
    private static final String URL = "jdbc:mysql://localhost:3306/brettspill";
    private static final String UNAME = "per";
    private static final String PWD = "per";
    private static final String GET_ALL_BOARDGAMES_SQL = "SELECT * FROM Brettspill";

    public List<BoardGame> getBoardGames() throws SQLException {
        List<BoardGame> boardGames = new ArrayList<>();
        try (Connection con = DriverManager
                .getConnection(URL, UNAME, PWD);
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
}
