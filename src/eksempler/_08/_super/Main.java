package eksempler._08._super;

public class Main {
    public static void main(String[] args) {
        ParentClass pc = new ParentClass();
        pc.setStringInParentClass("Parent string");
        MiddleClass mc = new MiddleClass();
        mc.setStringInMiddleClass("Middle string");
        mc.setStringInParentClass("Parent string set in middle class");
        SubClass sc = new SubClass();
        sc.setStringInSubClass("Sub string");
        sc.setStringInMiddleClass("Middle string set in sub class");
        sc.setStringInParentClass("Parent string set in sub class");

        System.out.println("XXX Calling pc.printState");
        pc.printState();
        System.out.println("XXX Calling mc.printState");
        mc.printState();
        System.out.println("XXX Calling sc.printState");
        sc.printState();

    }
}
