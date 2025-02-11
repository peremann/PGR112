package eksempler._07.skateboardMemorabilia;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private Inventory inventory;

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void openShop() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the coolest skateboard shop in town!");
        int choice = 0;
        while(choice!=5){
            System.out.println("Please select:\n1: See all boards" +
                    "\n2: Boards within budget" +
                    "\n3: Boards by celebrity" +
                    "\n4: Add skateboard" +
                    "\n5: Quit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 -> seeAllBoards();
                case 2 -> seeBoardsByBudget();
                case 3 -> seeBoardsByCelebrity();
                case 4 -> addNewSkateboard();
                case 5 -> quit();
                default -> System.out.println("Please select 1-5");
            }
        }
    }

    private void addNewSkateboard() {
        Skateboard newSkateBoard = new Skateboard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the model?");
        String model = scanner.nextLine();
        newSkateBoard.setModel(model);
        System.out.println("What year is it from? (YYYY)");
        Year year = Year.parse(scanner.nextLine());
        newSkateBoard.setYear(year);
        System.out.println("What celebrity is involved?");
        String celeb = scanner.nextLine();
        newSkateBoard.setCelebrityInvolved(celeb);
        System.out.println("Why is it a memorabilia?");
        String description = scanner.nextLine();
        newSkateBoard.setDescription(description);
        System.out.println("Why is the asking price?");
        int askingPrice = Integer.parseInt(scanner.nextLine());
        newSkateBoard.setAskingPrice(askingPrice);
        inventory.addSkateboard(newSkateBoard);
    }

    private void seeAllBoards() {
        ArrayList<Skateboard> allBoards = inventory.getAllBoards();
        System.out.println("Look at all these beautiful skateboards:");
        for (Skateboard board : allBoards) {
            System.out.println(board);
        }
    }

    private void seeBoardsByBudget() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your budget?");
        int budget = Integer.parseInt(scanner.nextLine());
        ArrayList<Skateboard> boardsWithinBudget = inventory.getBoardsWithinBudget(budget);
        if(boardsWithinBudget.isEmpty()){
            System.out.println("Sorry - no skateboard for you...");
        }else{
            System.out.println("Find anything nice?");
        }
        for (Skateboard skateboard : boardsWithinBudget) {
            System.out.println(skateboard);
        }
    }

    private void seeBoardsByCelebrity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What celebrity are you looking for?");
        String celeb = scanner.nextLine();
        ArrayList<Skateboard> boardsByCelebrity = inventory.getBoardsByCelebrity(celeb);
        if(boardsByCelebrity.isEmpty()){
            System.out.println("Sorry - no skateboard for that celebrity...");
        }else{
            System.out.println("Find anything nice?");
        }
        for (Skateboard skateboard : boardsByCelebrity) {
            System.out.println(skateboard);
        }
    }

    private void quit() throws IOException {
        inventory.storeSkateboardsOnFile();
        System.out.println("Bye!");
    }
}
