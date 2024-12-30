package eksempler._10.immutable;

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog(1, 12, "Pluto");
        Dog d2 = new Dog(2);
        System.out.println(d);
        System.out.println(d2);
    }
}
