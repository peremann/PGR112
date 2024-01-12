package loesninger._02;

import java.util.Random;

public class Person {
    String message;
    int counter;
    public void whisperMessage(){
        System.out.println("I am person number " + counter);
        System.out.println(message);
        if(hitting80Percent()){
            Person p = new Person();
            p.message = message;
            p.counter = counter + 1;
            p.whisperMessage();
        } else{
            System.out.println("Not hitting the 80%...");
        }
        System.out.println("WhisperMessage done. Counter = "+counter);
    }

    private boolean hitting80Percent(){
        Random r = new Random();
        int i = r.nextInt(10);
        if(i<8){
            return true;
        } else{
            return false;
        }
    }
}
