package eksempler._15;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BoardGameProvider bgp = new BoardGameProvider();
        List<BoardGame> boardGames = null;
        try {
            // Getting all board games
            System.out.println("Getting all board games");
            boardGames = bgp.getBoardGames();
            printAllBoardGames(boardGames);
            // Getting board game with id=3
            System.out.println("Getting board game with id=3");
            BoardGame bg = bgp.getBoardGame(3);
            System.out.println(bg);
            // Adding a board game
            System.out.println("Adding board game");
            BoardGame newBoardGame = new BoardGame(6, "Agricola", "Strategi", 5, 90, 12, "agricola.jpg");
            int rowsAffected = bgp.addBoardGame(newBoardGame);
            System.out.println("Rows affected:"+rowsAffected);
            boardGames = bgp.getBoardGames();
            printAllBoardGames(boardGames);
            //Updating a board game
            System.out.println("Updating new board game");
            BoardGame updatedBoardGame = new BoardGame(newBoardGame.id(), newBoardGame.name(), newBoardGame.type(), newBoardGame.nrOfPlayers(), 199, 99, newBoardGame.imageUrl());
            rowsAffected = bgp.updateBoardGame(updatedBoardGame);
            System.out.println("Rows affected:"+rowsAffected);
            boardGames = bgp.getBoardGames();
            printAllBoardGames(boardGames);
            //Deleting a board game
            System.out.println("Trying to delete the new board game");
            rowsAffected = bgp.deleteBoardGame(6);
            System.out.println("Rows affected:"+rowsAffected);
            boardGames = bgp.getBoardGames();
            printAllBoardGames(boardGames);

        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     *
     * For convenience as we do this repeatedly in main.
     */
    private static void printAllBoardGames(List<BoardGame> boardGames) {
        System.out.println("All board games:");
        for (BoardGame boardGame : boardGames) {
            System.out.println(boardGame);
        }
    }
}
