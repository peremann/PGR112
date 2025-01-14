package eksempler._03.cakeLottery_v2;

public class CakeLottery {
    public static void main(String[] args) {
        WinnerSelector ws = new WinnerSelector();
        String[] names = {"Frederic", "Inga", "Mohammed", "Lisa"};
        String winner1 = ws.selectWinner(names);
        System.out.println("Winner first try:"+winner1);
        //String[] names2 = {"a", "b", "c", "d", "e", "f"};
        String winner2 = ws.selectWinner(names);
        System.out.println("Winner second try:"+winner2);
    }
}
