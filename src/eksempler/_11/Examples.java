package eksempler._11;

import java.time.LocalDate;

import static java.lang.Math.*;

public class Examples {

    private static int someInt = 1;
    private static String someString;
    private static final String SOME_CONSTANT = "Nydelig konstant";
    private static final String SOME_OTHER_CONSTANT;

    static{
        System.out.println("In beginning of static block");
        someString = String.format("Today is %tA!", LocalDate.now());
    }

    static{
        System.out.println("Wow, I can even have multiple static blocks...");
        SOME_OTHER_CONSTANT = "Enda nydeligere konstant...";
    }

    private Examples(){
        // By creating this private constructor, I may only create Example objects from within this class
    }
    public static void main(String[] args) {
        System.out.printf("Value of my static variables are %d and %s%n", someInt, someString);
        System.out.printf("My constants are %s and %s%n", SOME_CONSTANT, SOME_OTHER_CONSTANT);

        // I am in a static context. I can only call static methods...
        formattingExamples();
        // Are we able to create an object og Example? Let's try...
    }

    private static void formattingExamples() {
        String name = "Ola";
        String artist = "Tix";
        // 1$ and 2$ referring to place in argument list
        // s is text
        String formattedText = String.format(
                "%1$s digger %2$s, eller hva, %1$s?", name, artist);
        System.out.println(formattedText);

        LocalDate now = LocalDate.now();
        // All referring to the same argument (1$)
        // t is date/time, A is day of the week, e is day of month
        // B is month name, Y is year
        String formattedText2 = String.format(
                "%1$tA %1$te. %1$tB %1$tY", now);
        System.out.println(formattedText2);

        System.out.println("Jeg må ikke referere til argumentets plassering:");
        // Look, I can use System.out.printf...
        System.out.printf("%s digger %s!%n", name, artist);
        // Above line better than line below?
        System.out.println(name + " digger " + artist + "!");
    }
}
