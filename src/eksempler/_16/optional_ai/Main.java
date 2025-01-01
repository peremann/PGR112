package eksempler._16.optional_ai;

import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        BoardGameProvider bgp = new BoardGameProvider();
        try {
            // Optional
            Optional<BoardGame> bg = bgp.getBoardGame(10);
            bg.ifPresent(boardGame -> System.out.println(boardGame.name()));

            // Auto increment
            int generatedId = bgp.addBoardGame("Citadels", "Strategi", 5, 180, 12, "citadels.jpg");
            System.out.println("Generated key:"+generatedId);
        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }

}
