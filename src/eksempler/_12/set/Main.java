package eksempler._12.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        HashSet<String> setOfStrings = new HashSet<>();
        setOfStrings.add("Dette");
        setOfStrings.add("Dette");
        setOfStrings.add("har");
        setOfStrings.add("har");
        setOfStrings.add("ingen");
        setOfStrings.add("ingen");
        setOfStrings.add("duplikater");
        setOfStrings.add("duplikater");
        for (String string : setOfStrings) {
            System.out.println(string);
        }
        System.out.println("---");
        for (String string : setOfStrings) {
            System.out.println(string);
        }

        // Traverse
        // Check contains and remove
    }

}
