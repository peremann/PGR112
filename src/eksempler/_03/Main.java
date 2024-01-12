package eksempler._03;

public class Main {
    public static void main(String[] args) {


        TheClass theClass = new TheClass();
        theClass.printRandomString();
        theClass.strings[1] = "sdfdf";
        theClass.strings[2] = "aaaaaa";
        theClass.printRandomString();

        String s1 = "hei";
        String s2 = "hei";
        boolean same = (s1==s2);
        System.out.println("SAme:"+same);
        System.out.println(s1==s2);

    }
}
