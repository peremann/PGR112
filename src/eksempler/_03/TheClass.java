package eksempler._03;

import java.util.Random;

public class TheClass {
    String[] strings = new String[]{"hei", "på", "deg"};

    public void printRandomString(){
        Random r = new Random();
        int i = r.nextInt(strings.length);
        System.out.println("String: "+strings[i]);
    }
}
