package eksempler._15.optional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        BoardGameProvider bgp = new BoardGameProvider();
        try {
            /*
            Optional<BoardGame> bg = bgp.getBoardGame(5);
            if(bg.isPresent()){
                System.out.println(bg.get().name());
            }
             */
            // Demo 1: test
            // Fix with Optional
            //Demo 2:
            BoardGame newBoardGame = new BoardGame(6, "Agricola", "Strategi", 5, 180, 12, "agricola.jpg");
            int rowsAffected = bgp.addBoardGame(newBoardGame);
            System.out.println("rowsAffected"+rowsAffected);
            int generatedId = bgp.addBoardGame("Citadels", "Strategi", 5, 180, 12, "citadels.jpg");
            System.out.println("Generated key:"+generatedId);
            //Create with autogenerated key
        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }

}