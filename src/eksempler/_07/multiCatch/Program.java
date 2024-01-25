package eksempler._07.multiCatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public void dummyMethod(){
        File file = new File("files/artister.txt");
        try {
            Scanner scanner = new Scanner(file);
            FileWriter writer = new FileWriter("ut.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
