package eksempler._16.callableStatement;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        BoardGameProvider bgp = new BoardGameProvider();
        try {
            System.out.println("Trying to add new board game using callable statement");
            BoardGame bg1 = new BoardGame(0, "Citadels", "Strategi", 7, 120, 10, "citadels.jpg");
            int generatedId = bgp.addBoardGameUsingStoredProcedure(bg1);
            System.out.println("Result:"+generatedId);
        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }

}
