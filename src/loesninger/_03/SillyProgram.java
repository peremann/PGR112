package loesninger._03;

import java.util.Random;
public class SillyProgram {
    String[] names = new String[] {"Per", "Lisa", "Armand"};
    String[] streetNames = new String[] {"Storgata", "Østliveien", "Vestveien", "Bestumveien"};
    int [] numbers = new int[] {1,2,3,4,5};
    char[] chars = {'a','b','c','d','e','f'};

    public void onePersonLiving(){
        System.out.println("onePersonLiving running");
        Random random = new Random();
        int index = random.nextInt(names.length);
        System.out.print(names[index] + " lives in ");
        index = random.nextInt(streetNames.length);
        System.out.print(streetNames[index] + " ");
        index = random.nextInt(numbers.length);
        System.out.print(numbers[index]);
        index = random.nextInt(chars.length);
        System.out.println(chars[index]);
    }

    public void allPersonsLiving(){
        System.out.println("allPersonsLiving running");
        Random random = new Random();
        for (int i = 0; i < names.length; i++){
            System.out.print(names[i] + " lives in ");
            int index = random.nextInt(streetNames.length);
            System.out.print(streetNames[index] + " ");
            index = random.nextInt(numbers.length);
            System.out.print(numbers[index]);
            index = random.nextInt(chars.length);
            System.out.println(chars[index]);
        }
    }

    public void printNumberOfCharsInStreetNames(){
        int totalChars = 0;
        for (int i = 0; i < streetNames.length; i++){
            totalChars = totalChars + streetNames[i].length();
        }
        System.out.println("Total number of chars in all street names: " + totalChars);
    }
}
