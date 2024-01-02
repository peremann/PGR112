package loesninger._06;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.setUserName(args[0]);
        BookRegister br = new BookRegister();
        br.initRegister();
        program.setBookRegister(br);
        program.run();
    }
}
