package eksempler._04;

public class Main {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.setSomeChar('a');
        mc.setSomeInt(1);
        mc.setSomeString("Stringen");

        System.out.println("mc.getSomeChar()"+mc.getSomeChar());
        System.out.println("mc.getSomeString()"+mc.getSomeString());
        System.out.println("mc.getSomeInt()"+mc.getSomeInt());
        // Set value through setters
        // Retrieve values through getters
        // Could I move weekday method to this class?

        mc.printWeekDay(2);
        Continent europe = Continent.EUROPE;
    }
}
