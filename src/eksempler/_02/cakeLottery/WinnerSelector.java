package eksempler._02.cakeLottery;

import java.util.Random;

public class WinnerSelector {
    String[] names = {"Per", "Inga", "Mohammed", "Leyry"};
    public void selectWinner(){
        // Bruke random til å trekke en tilfeldig vinner
        Random random = new Random();
        int range = names.length;
        System.out.println("Range:"+range);
        int random1 = random.nextInt(names.length);
        System.out.println("Random:"+random1);
        String randomWinner = names[random1];
        // Informer om hvem som vant
        System.out.println("The winner is:" + randomWinner);
    }
}
