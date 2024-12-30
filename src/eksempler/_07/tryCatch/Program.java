package eksempler._07.tryCatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public void methodA() throws FileNotFoundException {
        System.out.println("In methodA...");
        System.out.println("Calling methodB...");
        methodB();
        System.out.println("MethodA done! Returning to caller.");
    }

    public void methodB() throws FileNotFoundException {
        System.out.println("In methodB...");
        System.out.println("Calling methodC...");
        methodC();
        System.out.println("MethodB done! Returning to caller.");
    }

    public void methodC() throws FileNotFoundException{
        System.out.println("In methodC...");
        File file = new File("files/artister.txt");
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            String s = input.nextLine();
            System.out.println(s);
        }
        input.close();
        System.out.println("MethodC done! Returning to caller.");
    }
}
