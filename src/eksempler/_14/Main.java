package eksempler._14;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brettspill", "<uname>", "<pwd>");
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM brettspill")){
            List<BoardGame> boardGames = new ArrayList<>();
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
            for (BoardGame boardGame : boardGames) {
                System.out.println(boardGame);
            }
        } catch(SQLException e){
            System.out.println("Unable to connect to database:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
