package eksempler._08.equalsHashCode;

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.setName("Per");
        Animal a2 = new Animal();
        a2.setName("Per");
        //Test equals
        boolean b = a1.equals(a2);
        System.out.println(b);
        //Test hashCode
        //Implement equals and hashCode in Animal
    }
}
