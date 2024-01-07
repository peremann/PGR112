package loesninger._10.books;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Program().run();
        } catch (IOException e) {
            System.out.println("Unable to ready/write from/to file:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
