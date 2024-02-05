package eksempler._15.transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BoardGameProvider bgp = new BoardGameProvider();
        try {
            System.out.println("Trying to add 5 new board games");
            List<BoardGame> newBoardGames = getBoardGamesToAdd();
            bgp.addBoardGames(newBoardGames);
        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<BoardGame> getBoardGamesToAdd() {
        List<BoardGame> newBoardGames = new ArrayList<>();
        newBoardGames.add(new BoardGame(6, "spill6", "Strategi", 5, 90, 12, "spill6.jpg"));
        newBoardGames.add(new BoardGame(7, "spill7", "Strategi", 5, 90, 12, "spill7.jpg"));
        newBoardGames.add(new BoardGame(7, "spill8", "Strategi", 5, 90, 12, "spill8.jpg"));
        newBoardGames.add(new BoardGame(9, "spill9", "Strategi", 5, 90, 12, "spill9.jpg"));
        newBoardGames.add(new BoardGame(10, "spill10", "Strategi", 5, 90, 12, "spill10.jpg"));
        return newBoardGames;
    }

}
