package eksempler._10.superduper;

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog(12, "Pluto");
        Dog d2 = new Dog("Pluto");
        Dog d3 = new Dog();
        System.out.println(d);
        System.out.println(d2);
        System.out.println(d3);
    }
}
