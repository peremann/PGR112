package eksempler._06.cakeLottery;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Program running.");
        CakeLottery cl = new CakeLottery();
        WinnerSelector ws = new WinnerSelector();
        //ws.populateEmployees();
        cl.setWinnerSelector(ws);
        cl.menu();
    }
}
