package eksempler._07.skateboardMemorabilia;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        handler.setFileName("files/skateboards.txt");
        Inventory inventory = new Inventory();
        inventory.setFileHandler(handler);
        try {
            inventory.retrieveSkateboardsFromFile();
            Shop shop = new Shop();
            shop.setInventory(inventory);
            shop.openShop();
        } catch (IOException e) {
            System.out.println("Unable to handle file:"+e.getMessage());
            e.printStackTrace();
        }

    }
}
