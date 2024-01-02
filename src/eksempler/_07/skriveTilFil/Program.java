package eksempler._07.skriveTilFil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public void methodA() {
        System.out.println("In methodA...");
        System.out.println("Calling methodB...");
        methodB();
        System.out.println("MethodA done! Returning to caller.");
    }

    public void methodB() {
        System.out.println("In methodB...");
        System.out.println("Calling methodC...");
        methodC();
        System.out.println("MethodB done! Returning to caller.");
    }

    public void methodC() {
        System.out.println("In methodC...");
        // Paste code from slide here...
        System.out.println("MethodC done! Returning to caller.");
    }
}
