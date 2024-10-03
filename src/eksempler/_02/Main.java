package eksempler._02;

public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.gear = 1;
        bicycle.speed = 5;
        bicycle.isFast = true;
        bicycle.speedUp(1);
        System.out.println("Look at my beautiful bicycle:");
        bicycle.printStates();

        Bicycle bicycle2 = new Bicycle();
        bicycle2.gear = 2;
        bicycle2.speed = 7;
        bicycle2.isFast = false;
        bicycle2.speedUp(10);
        bicycle2.changeGear(3);
        System.out.println("Look at my beautiful bicycle2:");
        bicycle2.printStates();
    }
}
