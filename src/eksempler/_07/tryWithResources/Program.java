package eksempler._07.tryWithResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public void dummyMethod(){
        File file = new File("eksempel.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
            while(input.hasNextLine()){
                System.out.println(input.nextLine());

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(input!=null){
                input.close();
            }
        }
    }
}
