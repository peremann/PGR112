package eksempler._12.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Per");
        map.put(1, "Sjokolade");
        map.put(2, "Pepsi Max");
        map.put(3, "Valheim");
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println(key);
        }

        //Test contains key/value (Per) isEmpty
        // Traverse all keys and values
        System.out.println("---");
        List<String> list = new ArrayList<>(map.values());
        for (String s : list) {
            System.out.println(s);
        }

    }

}
