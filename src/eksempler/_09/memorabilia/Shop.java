package eksempler._09.memorabilia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private Inventory inventory;

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void openShop() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the coolest memorabilia shop in town!");
        int choice = 0;
        while(choice!=2){
            System.out.println("Please select:\n1: See all memorabilia" +
                    "\n2: Quit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 -> seeAllMemorabilia();
                case 2 -> quit();
                default -> System.out.println("Please select 1-2");
            }
        }
    }



    private void seeAllMemorabilia() {
        ArrayList<Memorabilia> allMemorabilia = inventory.getAllMemorabilia();
        System.out.println("Look at all these beautiful memorabilia:");
        for (Memorabilia mem : allMemorabilia) {
            System.out.println(mem);
        }
    }



    private void quit() throws IOException {
        System.out.println("Bye!");
    }
}
