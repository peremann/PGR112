package eksempler._07.tryCatch;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting main");
        Program p = new Program();
        System.out.println("Calling methodA");
        try {
            p.methodA();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run properly. Exception caught: "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("main done. Program done:)");
    }
}
