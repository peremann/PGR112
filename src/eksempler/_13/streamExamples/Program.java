package eksempler._13.streamExamples;

import java.util.*;
import java.util.function.Predicate;

public class Program {
    List<String> strings;
    Set<Integer> ints;
    Map<Integer, String> map;

    public Program(){
        strings = TestDataProvider.getStrings();
        ints = TestDataProvider.getIntegers();
        map = TestDataProvider.getMap();
    }
    public void run(){
        //print();
        //biggestValue();
        //count();
        //sort();
        //reduce();
        match();
    }

    private void match() {
        System.out.println("All ints are less then 100");
        System.out.println(ints.stream().allMatch(i->i<100));
        System.out.println("I have a word including the letter x");
        System.out.println(strings.stream().anyMatch(s->s.contains("x")));
        System.out.println("I have a word of max 3 letters including the letter x");
        System.out.println(strings.stream().filter((s)->s.length()<=3).anyMatch(s->s.contains("x")));
        System.out.println("Show me a word of max 3 letters including the letter x");
        Optional<String> xWord = strings.stream()
                .filter(s->s.toLowerCase().contains("x"))
                .filter(s->s.length()<=3)
                .findAny();
        xWord.ifPresent(System.out::println);
        System.out.println("No int is dividable by 17:");
        Predicate<Integer> dividableBy17 = i->i%17==0;
        System.out.println(ints.stream().noneMatch(dividableBy17));
        System.out.println("Show me all ints dividable by 17, sorted:");
        ints.stream().filter(dividableBy17).sorted().forEach(System.out::println);
    }

    private void reduce() {
        System.out.println("Sum of all but 10 ints:");
        System.out.println(ints.stream().skip(10).reduce(0, Integer::sum));
        System.out.println("Will I get 50+?");
        System.out.println(ints.stream().skip(10).reduce(50, Integer::sum));
    }

    public void sort(){
        System.out.println("10 first strings in alphabetic order:");
        strings.stream().limit(10).sorted().forEach(System.out::println);
        System.out.println("10 longest words in alphabetic order and in upper case:");
        strings.stream()
                .distinct()
                .sorted((s1, s2)->s2.length() - s1.length())
                .limit(10)
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private void count() {
        System.out.println("Number of strings");
        System.out.println(strings.size());
        System.out.println("Number of unique strings");
        System.out.println(strings.stream().distinct().count());
        System.out.println("Number of ints less than 20:");
        System.out.println(ints.stream().filter(i->i<20).count());
        System.out.println("Number of entries in map:");
        System.out.println(map.entrySet().size());
        System.out.println("Number of values in map where string is longer than 7:");
        System.out.println(map.values().stream().filter(s->s.length()>7).count());
        System.out.println("Number of keys in map with value less than 7:");
        System.out.println(map.keySet().stream().filter(i->i<7).count());
    }

    private void print() {
        System.out.println("All strings:");
        strings.forEach(System.out::println);
        System.out.println("All ints:");
        ints.forEach(System.out::println);
        System.out.println("All ints dividable by 5 in increasing order:");
        ints.stream()
                .filter(i->i%5==0)
                .sorted()
                .forEach(System.out::println);
        System.out.println("All entries in map:");
        map.entrySet().forEach(System.out::println);
        System.out.println("All keys in map:");
        map.keySet().forEach(System.out::println);
        System.out.println("All values in map:");
        map.values().forEach(System.out::println);
    }

    private void biggestValue() {
        OptionalInt max = ints.stream().mapToInt(Integer::intValue).max();
        System.out.println("Biggest int:");
        max.ifPresent(System.out::println);
        // Or using reduce
        System.out.println("Biggest int, take 2:");
        Optional<Integer> max2 = ints.stream().sorted().reduce((first, second)->second);
        max2.ifPresent(System.out::println);
        // Or using skip
        System.out.println("Biggest int, take 3:");
        Optional<Integer> max3 = ints.stream().sorted().skip(ints.size()-1).findFirst();
        max3.ifPresent(System.out::println);
        // Or using alternative reduce
        System.out.println("Biggest int, take 4:");
        Optional<Integer> max4 = ints.stream().reduce(Integer::max);
        max4.ifPresent(System.out::println);
        // Or using max with comparator
        System.out.println("Biggest int, take 5:");
        Optional<Integer> max5 = ints.stream().max(Comparator.comparingInt(i -> i));
        max5.ifPresent(System.out::println);
    }
}
