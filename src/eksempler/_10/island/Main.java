package eksempler._10.island;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Per");
        Person p2 = new Person("Lotta", p1);
        p1.setClosestRelative(p2);
        System.out.println("Cool, I have two new objects...");
        p1 = null;
        p2 = null;
        System.out.println("GC ready?");


    }
}
