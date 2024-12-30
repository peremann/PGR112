package eksempler._07.nullpointerException;

public class Program {
    public int totalLength(String s1, String s2) {
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        int i1 = 0;
        int i2 = 0;
        if(s1!=null){
            i1 = s1.length();
        }
        if(s2!=null){
            i2 = s2.length();
        }
        return i1+i2;
    }

    /**
     * Returns the sum length of the two provided strings
     * @param s1 the first string
     * @param s2 the second string
     * @return the sum length of the two provided strings
     * @throws IllegalArgumentException if one or both strings are null
     */
    public int totalLengthAlternative(String s1, String s2) {
        if(s1==null||s2==null){
            throw new IllegalArgumentException("Non-null values expected");
        }
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        System.out.println("s1.length():" + s1.length());
        System.out.println("s2.length():" + s2.length());
        return s1.length()+s2.length();
    }
}
