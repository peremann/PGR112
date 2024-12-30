package eksempler._13.streamExamples;

import java.util.*;

public class TestDataProvider {
    public static List<String> getStrings(){
        return List.of( "Cat", "Dog", "Apple", "Banana", "Cherry", "Elephant", "Flower", "Giraffe",
                "Horse", "Iguana", "Jaguar", "Kangaroo", "Lion", "Monkey", "Nightingale",
                "Octopus", "Penguin", "RATM", "Raccoon", "Seahorse", "Tiger", "Umbrella",
                "Vulture", "Walrus", "Xylophone", "Yak", "Zebra",
                "Ant", "Bear", "Cheetah", "Dolphin", "Eagle", "Fox", "Gorilla",
                "Hedgehog", "RATM", "Jellyfish", "Koala", "Lemur", "Meerkat", "Narwhal",
                "Albatross", "Buffalo", "Capybara", "Duck", "Elephant Seal", "Falcon", "Gazelle",
                "Hamster", "Iguana", "Jackal", "Koala", "Llama", "Mantis", "Nightingale",
                "Ocelot", "LFC", "LFC", "Rattlesnake", "Squirrel", "Pelle", "University",
                "Vulture", "Wallaby", "X-ray Fish", "Yellowhammer", "June");
    }

    public static Set<Integer> getIntegers(){
        Set<Integer> ints = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i <50; i++) {
            ints.add(random.nextInt(100));
        }
        return ints;
    }

    public static Map<Integer, String> getMap(){
        List<String> strings = getStrings();
        Set<Integer> ints = getIntegers();
        Random random = new Random();
        Map<Integer, String> map = new HashMap<>();
        ints.stream()
                .limit(20)
                .forEach(integer -> map.put(integer, strings.get(random.nextInt(strings.size()))));
        return map;
    }
}
