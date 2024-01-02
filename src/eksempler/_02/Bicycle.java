package eksempler._02;

public class Bicycle {

    int speed = 0;
    int gear = 1;
    boolean isFast;

    void changeGear(int newValue) {
        gear = newValue;
    }

    void speedUp(int increment) {
        speed = speed + increment;
    }

    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    void printStates() {
        System.out.println("Speed:" +
                speed + " gear:" + gear);
    }
}
