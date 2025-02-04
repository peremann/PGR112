package eksempler._06.football;

import java.util.ArrayList;
import java.util.Scanner;

public class FootballProgram {
    /*
    a. see all players
                b. addPlayer
                c. quit
     */
    private FootballPlayerCollection fpc;

    public void setFpc(FootballPlayerCollection fpc) {
        this.fpc = fpc;
    }

    public void menu(){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while(choice!=3){
            System.out.println("Make a choice:\n1: See all players\n2: Add player\n3: Quit");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> seeAllPlayers();
                case 2 -> addPlayer();
                case 3 -> quit();
                default -> System.out.println("Please select 1-3");
            }
        }

    }

    private void quit() {
        System.out.println("Bye!");
    }

    private void addPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter salary:");
        String salaryAsText = scanner.nextLine();
        int salary = Integer.parseInt(salaryAsText);
        System.out.println("Enter age:");
        String ageAsText = scanner.nextLine();
        int age = Integer.parseInt(ageAsText);
        FootballPlayer newPlayer = new FootballPlayer();
        newPlayer.setSalary(salary);
        newPlayer.setName(name);
        newPlayer.setYears(age);
        fpc.addPlayer(newPlayer);
    }

    private void seeAllPlayers() {
        System.out.println("Here are all players:");
        ArrayList<FootballPlayer> allPlayers = fpc.getPlayers();
        for (FootballPlayer player : allPlayers) {
            System.out.println(player);
        }
    }
}
