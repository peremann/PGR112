package loesninger._16.australiaSplit;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Program p = new Program();
        try {
            p.splitAustralia();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught:"+e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL exception caught:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
