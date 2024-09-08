package eksempler._04;

public class Main {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.setSomeChar('a');
        mc.setSomeInt(12);
        mc.setSomeString("Hei");
        mc.setSomeContinent(Continent.OCEANIA);

        System.out.println("mc.getSomeChar()"+mc.getSomeChar());
        System.out.println("mc.getSomeString()"+mc.getSomeString());
        System.out.println("mc.getSomeInt()"+mc.getSomeInt());
        System.out.println("mc.getSomeContinent()"+mc.getSomeContinent());
    }
}
