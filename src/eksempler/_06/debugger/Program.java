package eksempler._06.debugger;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice!=3){
            System.out.println("Pick a number (1-3)");
            System.out.println("1: Division");
            System.out.println("2: Enter date");
            System.out.println("3: Quit");
            choice = scanner.nextInt();
            switch(choice){
                case 1 -> divideTwoNumbers();
                case 2 -> enterDate();
                case 3 -> quit();
                default -> System.out.println("Enter 1-3, please");
            }
        }
    }

    private void quit() {
        System.out.println("Bye!");
    }

    private void enterDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date on format YYYY-MM-DD");
        String s = scanner.nextLine();
        LocalDate date = LocalDate.parse(s);
        System.out.println("You entered:" + date);
    }

    private void divideTwoNumbers() {
        System.out.println("Hi! Let me divide two numbers for you.");
        System.out.println("Enter first number");
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        System.out.println("Second number");
        int number2 = scanner.nextInt();
        int result = number1 / number2;
        System.out.println("The result is:"+result);
    }
}
