package eksempler._10.constructor;

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog(1, "Bajas");
        Dog d2 = new Dog(1);
        d2.setName("Per");
        System.out.println(d);
        System.out.println(d2);
    }
}
