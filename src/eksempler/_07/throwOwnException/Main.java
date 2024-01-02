package eksempler._07.throwOwnException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting main");
        Program p = new Program();
        int result = p.totalSum("11", "12");
        System.out.println("Result:"+result);
        System.out.println("main done. Program done:)");
    }
}
