package eksempler._12.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Per");
        map.put(1, "Sjokolade");
        map.put(2, "Pepsi Max");
        map.put(3, "Valheim");

        System.out.println("Contains key 2:" + map.containsKey(2));
        System.out.println("Contains value Sjokolade:" + map.containsValue("Sjokolade"));
        System.out.println("Contains value Per:" + map.containsValue("Per"));
        System.out.println("Is empty:" + map.isEmpty());

        Set<Integer> keys = map.keySet();
        System.out.println("Keys:");
        for (Integer key : keys) {
            System.out.println(key);
        }

        List<String> strings = new ArrayList<>(map.values());
        System.out.println("Values:");
        for (String string : strings) {
            System.out.println(string);
        }

    }

}
