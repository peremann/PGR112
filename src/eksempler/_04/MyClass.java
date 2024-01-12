package eksempler._04;

public class MyClass {
    private String someString;
    private char someChar;
    private int someInt;

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public char getSomeChar() {
        return someChar;
    }

    public void setSomeChar(char someChar) {
        this.someChar = someChar;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    //Generate getters and setters
    // Add field for enum Continent.


    public void printWeekDay(int day){
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Day not recognized:" + day);
        }
    }
}
