package eksempler._07.nullpointerException;

public class Program {
    public int totalLength(String s1, String s2){
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        System.out.println("s1.length():" + s1.length());
        System.out.println("s2.length():" + s2.length());
        return s1.length()+s2.length();
    }

    public void dummyMethod() {
    }
}
