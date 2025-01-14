package eksempler._03.cakeLottery_v2;

import java.util.Random;

public class WinnerSelector {

    public String selectWinner(String[] names){
        int range = names.length;
        System.out.println("Range:"+range);
        Random random = new Random();
        int random1 = random.nextInt(range);
        System.out.println("Random:"+random1);
        return names[random1];
    }


}
