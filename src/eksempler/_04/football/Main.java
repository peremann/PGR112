package eksempler._04.football;

public class Main {
    public static void main(String[] args) {
        // Create three football players
        FootballPlayer footballPlayer1 = new FootballPlayer();
        footballPlayer1.setName("Ronaldo");
        footballPlayer1.setSalary(10000000);
        footballPlayer1.setYears(38);
        FootballPlayer footballPlayer2 = new FootballPlayer();
        footballPlayer2.setName("Messi");
        footballPlayer2.setSalary(100000000);
        footballPlayer2.setYears(37);
        FootballPlayer footballPlayer3 = new FootballPlayer();
        footballPlayer3.setName("Huzefa");
        footballPlayer3.setSalary(1000000000);
        footballPlayer3.setYears(22);
        // Place them in an array
        FootballPlayer[] footballPlayers = new FootballPlayer[3];
        footballPlayers[0] = footballPlayer1;
        footballPlayers[1] = footballPlayer2;
        footballPlayers[2] = footballPlayer3;
        // Figure out how much they earn in total
        SalaryComputator sc = new SalaryComputator();
        int totalSalary = sc.computeSalary(footballPlayers);
        System.out.println("Total salary: "+totalSalary);

    }
}
