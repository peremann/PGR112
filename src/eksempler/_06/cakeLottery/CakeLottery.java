package eksempler._06.cakeLottery;

import java.util.Scanner;

public class CakeLottery {

    private WinnerSelector winnerSelector;

    public void setWinnerSelector(WinnerSelector winnerSelector) {
        this.winnerSelector = winnerSelector;
    }

    public void menu(){
        int choice = -14;
        while(choice!=3){
            System.out.println("Here are your options:");
            System.out.println("1: Add employee");
            System.out.println("2: Pick cake winner");
            System.out.println("3: Quit");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> addEmployee();
                case 2 -> selectWinner();
                case 3 -> quit();
                default -> System.out.println("Please choose 1-3");
            }
        }

    }

    private void quit() {
        System.out.println("Sayonara!");
    }

    private void selectWinner() {
        System.out.println("Winner:");
        System.out.println(winnerSelector.pickWinner());
    }

    private void addEmployee() {
        System.out.println("Her I will add employee (TODO)");
    }
}
