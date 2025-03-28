package eksempler._15.memorabilia;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    /*
    You need to run the db-script memorabilia.sql before running this program.
    It is placed in the files folder.
     */
    public static void main(String[] args) {
        MemorabiliaImporter importer = new MemorabiliaImporter();
        Inventory inventory = new Inventory();
        try {
            // After having called this method (importMemorabilia) once, you need to comment it out
            // You don't want to import more than once...
            importer.importMemorabilia();
            Shop shop = new Shop();
            shop.setInventory(inventory);
            shop.openShop();
        } catch (IOException e) {
            System.out.println("Unable to handle file:"+e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
