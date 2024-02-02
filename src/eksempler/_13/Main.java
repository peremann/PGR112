package eksempler._13;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BoardGameProvider bgp = new BoardGameProvider();
        List<BoardGame> boardGames = null;
        try {
            boardGames = bgp.getBoardGames();
        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
        for (BoardGame boardGame : boardGames) {
            System.out.println(boardGame);
        }
    }
}
