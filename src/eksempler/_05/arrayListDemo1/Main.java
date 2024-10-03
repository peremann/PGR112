package eksempler._05.arrayListDemo1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("String1");
        strings.add("String2");
        strings.add(0, "String3");

        for (String s : strings){
            System.out.println(s);
        }
        System.out.println("Remove on index 1");
        strings.remove(1);
        System.out.println("Size: " + strings.size());
        System.out.println("Adding 4 and 4");
        strings.add("String4");
        strings.add("String5");
        for (String s : strings){
            System.out.println(s);
        }
        System.out.println("IsEmpty:"+strings.isEmpty());
        System.out.println("ToString:"+strings.toString());
        System.out.println("Contains 4:" + strings.contains("String4"));
        System.out.println("IndexOf 4:" + strings.indexOf("String4"));

    }
}
