package eksempler._07.nullpointerException;

public class Program {
    /**
     * Method beskr
     * @param s1
     * @param s2
     * @return
     * @throws IllegalArgumentException
     */
    public int totalLength(String s1, String s2) {
        if(s1==null||s2==null){
            throw new IllegalArgumentException("Non-null values expected");
        }
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        System.out.println("s1.length():" + s1.length());
        System.out.println("s2.length():" + s2.length());
        return s1.length()+s2.length();
    }

    public void dummyMethod() {
    }
}
