package loesninger._07.booksAndFiles;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        BookRegister br = new BookRegister();
        try {
            br.initRegister();
            program.setBookRegister(br);
            program.run();
        } catch (IOException e) {
            System.out.println("Unable to ready/write from/to file:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
