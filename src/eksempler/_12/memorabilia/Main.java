package eksempler._12.memorabilia;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        handler.setFileName("files/memorabilia.txt");
        Inventory inventory = new Inventory();
        inventory.setFileHandler(handler);
        try {
            inventory.retrieveMemorabiliaFromFile();
            Shop shop = new Shop();
            shop.setInventory(inventory);
            shop.openShop();
        } catch (IOException e) {
            System.out.println("Unable to handle file:"+e.getMessage());
            e.printStackTrace();
        }

    }
}
