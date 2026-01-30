package eksempler._06.cakeLottery;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program running.");
        CakeLottery cl = new CakeLottery();
        WinnerSelector ws = new WinnerSelector();
        ws.populateEmployees();
        cl.setWinnerSelector(ws);
        cl.menu();
    }
}
