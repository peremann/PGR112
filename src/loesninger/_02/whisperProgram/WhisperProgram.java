package loesninger._02.whisperProgram;

public class WhisperProgram {
    public void run(){
        System.out.println("Program running!");
        Person p = new Person();
        p.message = "Secret message...";
        p.counter = 1;
        p.whisperMessage();
        System.out.println("Run done!");
    }
}
