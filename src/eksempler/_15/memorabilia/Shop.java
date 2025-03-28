package eksempler._15.memorabilia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class Shop {
    private Inventory inventory;
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void openShop() throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the coolest memorabilia shop in town!");
        int choice = 0;
        while(choice!=3){
            System.out.println("Please select:\n1: See all memorabilia" +
                    "\n2: Max price\n3: Quit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 -> seeAllMemorabilia();
                case 2 -> memorabiliaByMaxPrize();
                case 3 -> quit();
                default -> System.out.println("Please select 1-3");
            }
        }
    }

    private void memorabiliaByMaxPrize() throws SQLException {
        Set<Memorabilia> allMemorabilia = inventory.getAllMemorabilia();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your max price?");
        int maxPrice = scanner.nextInt();
        allMemorabilia.stream()
                .filter(memorabilia->memorabilia.getAskingPrice()<=maxPrice)
                .sorted((m1, m2)-> m1.getAskingPrice()-m2.getAskingPrice())
                .forEach(System.out::println);
    }

    private void seeAllMemorabilia() throws SQLException {
        Set<Memorabilia> allMemorabilia = inventory.getAllMemorabilia();
        System.out.println("Look at all these beautiful memorabilia:");
        for (Memorabilia mem : allMemorabilia) {
            System.out.println(mem);
        }
    }

    private void quit() throws IOException {
        System.out.println("Bye!");
    }
}
