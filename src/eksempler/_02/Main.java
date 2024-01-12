package eksempler._02;

public class Main {
    public static void main(String[] args) {
        Bicycle bicycle1 = new Bicycle();
        bicycle1.gear = 1;
        bicycle1.speed = 5;
        bicycle1.isFast = true;
        bicycle1.speedUp(1);
        System.out.println("Look at my beautiful bicycle:");
        bicycle1.printStates();

        Bicycle bicycle2 = new Bicycle();
        bicycle2.gear = 2;
        bicycle2.speed = 7;
        bicycle2.isFast = false;
        bicycle2.speedUp(10);
        System.out.println("Look at my beautiful bicycle2:");
        bicycle2.printStates();

        bicycle2.speedUntil20();

    }
}
