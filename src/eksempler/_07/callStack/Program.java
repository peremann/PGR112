package eksempler._07.callStack;

public class Program {
    public void methodA() {
        System.out.println("In methodA...");
        System.out.println("Calling methodB...");
        try {
            methodB();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught!");
        }
        System.out.println("MethodA done! Returning to caller.");
    }

    public void methodB() {
        System.out.println("In methodB...");
        System.out.println("Calling methodC...");
        methodC();
        System.out.println("MethodB done! Returning to caller.");
    }

    public void methodC() {
        System.out.println("In methodC...");

        int i1 = 5;
        int i2 = 0;
        System.out.println("i1/i2=" + i1/i2);

        System.out.println("MethodC done! Returning to caller.");
    }
}
