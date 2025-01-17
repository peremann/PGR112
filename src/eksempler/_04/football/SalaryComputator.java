package eksempler._04.football;

public class SalaryComputator {
    public int computeSalary(FootballPlayer[] footballPlayers){
        int sum = 0;
        for (int i = 0; i < footballPlayers.length; i++) {
            sum += footballPlayers[i].getSalary();
        }
        return sum;
    }
}
