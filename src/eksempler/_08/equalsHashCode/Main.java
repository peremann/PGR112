package eksempler._08.equalsHashCode;

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.setName("Per");
        Animal a2 = new Animal();
        a2.setName("Per");
        boolean equal = a1.equals(a2);
        System.out.println(equal);
        int i = a1.hashCode();
        int j = a2.hashCode();
        System.out.println(i);
        System.out.println(j);
    }
}
