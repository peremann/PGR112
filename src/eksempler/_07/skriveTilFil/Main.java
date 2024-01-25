package eksempler._07.skriveTilFil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting main");
        Program p = new Program();
        System.out.println("Calling methodA");
        try {
            p.methodA();
        } catch (IOException e) {
            System.out.println("Exception caught:"+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("main done. Program done:)");
    }
}
