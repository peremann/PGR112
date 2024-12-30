package eksempler._13.intro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> listOfStrings = List.of("En", "To", "Tre");
        listOfStrings.stream()
                .filter((s->s.toLowerCase().contains("e")))
                .forEach(System.out::println);
        System.out.println("Original strings:");
        for (String stringInList : listOfStrings){
            System.out.println(stringInList);
        }
    }
}
