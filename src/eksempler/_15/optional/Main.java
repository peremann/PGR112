package eksempler._15.optional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        BoardGameProvider bgp = new BoardGameProvider();
        try {
            System.out.println("Trying to get board game with id=10");
            BoardGame bg1 = bgp.getBoardGame(10);
            System.out.println(bg1.name());
            //Demo 1: Change to Optional

            //Demo2: Use auto-increment on create
            // What to return? BoardGame? Generated id?
            //int id = bgp.addBoardGame("a", "b", 4, 90, 12, "url");
            //System.out.println("id:"+id);
        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }

}
