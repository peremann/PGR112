package eksempler._07.spotify;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public void run(){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while(choice!=3){
            System.out.println("Please choose\n1: Something\n2: Something else\n3: Quit");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("That is not a number. Try again...");
                continue;
            }
            switch (choice){
                case 1 -> doSomething();
                case 2 -> doSomethingElse();
                case 3 -> quit();
                default -> System.out.println("Please choose a number 1-3");
            }
        }
        System.out.println("");
    }

    private void quit() {
        System.out.println("Bye!");
    }

    private void doSomethingElse() {
        System.out.println("Doing something else");
    }

    private void doSomething() {
        System.out.println("Doing something");
    }

    public void checkWriteToFile() throws IOException {
        File file = new File("tullefil.txt");
        boolean created = file.createNewFile();
        System.out.println("Created:"+created);
        FileWriter writer = new FileWriter(file);
        writer.write("test");
        writer.close();

    }
}
