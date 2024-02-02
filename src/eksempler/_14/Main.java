package eksempler._14;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BoardGameProvider bgp = new BoardGameProvider();
        try {
            // Retrieving all boardgames
            List<BoardGame> boardGames = bgp.getBoardGames();
            printAllBoardGames(boardGames);
            // Adding a board game
            System.out.println("Trying to add a board game");
            BoardGame bg = new BoardGame(6, "Agricola", "Strategi", 5, 90, 12, "agricola.jpg");
            int rowsAffected = bgp.addBoardGame(bg);
            System.out.println("Rows affected:"+rowsAffected);
            boardGames = bgp.getBoardGames();
            printAllBoardGames(boardGames);
            //Updating a board game
            System.out.println("Trying to update the new board game with age limit 99 and minutes 199");
            BoardGame updatedBoardGame = new BoardGame(bg.id(), bg.name(), bg.type(), bg.nrOfPlayers(), 199, 99, bg.imageUrl());
            rowsAffected = bgp.updateBoardGame(updatedBoardGame);
            System.out.println("Rows affected:"+rowsAffected);
            boardGames = bgp.getBoardGames();
            printAllBoardGames(boardGames);
            //Deleting a board game
            System.out.println("Trying to delete the new board game");
            rowsAffected = bgp.deleteBoardGame(updatedBoardGame);
            System.out.println("Rows affected:"+rowsAffected);
            boardGames = bgp.getBoardGames();
            printAllBoardGames(boardGames);
            //Get board game from id
            System.out.println("Trying to get board game with id=1");
            BoardGame bg1 = bgp.getBoardGame(1);
            System.out.println(bg1);

        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printAllBoardGames(List<BoardGame> boardGames) {
        System.out.println("All board games:");
        for (BoardGame boardGame : boardGames) {
            System.out.println(boardGame);
        }
    }
}
