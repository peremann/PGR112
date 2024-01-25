package eksempler._07.nullpointerException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting main");
        Program p = new Program();
        int result = p.totalLength("Hei", null);
        System.out.println("Result:"+result);
        System.out.println("main done. Program done:)");
    }
}
