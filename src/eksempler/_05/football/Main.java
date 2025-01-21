package eksempler._05.football;

import java.util.ArrayList;

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
        ArrayList<FootballPlayer> players = new ArrayList<>();
        players.add(footballPlayer1);
        players.add(footballPlayer2);
        players.add(footballPlayer3);

        // Figure out how much they earn in total
        FootballPlayerCollection fpc = new FootballPlayerCollection();
        fpc.setPlayers(players);
        int totalSalary = fpc.computeSalary();
        System.out.println("Total salary: "+totalSalary);

        FootballPlayer footballPlayer4 = new FootballPlayer();
        footballPlayer4.setName("Frederic");
        footballPlayer4.setSalary(100000000);
        footballPlayer4.setYears(40);

        fpc.addPlayer(footballPlayer4);
        totalSalary = fpc.computeSalary();
        System.out.println("Total salary: "+totalSalary);

        FootballPlayer result = fpc.getPlayer("Per");
        if(result!=null){
            System.out.println("Found player:"+result.getName());
        } else {
            System.out.println("No football player found");
        }

        result = fpc.getPlayer("Frederic");
        if(result!=null){
            System.out.println("Found player:"+result.getName());
        } else {
            System.out.println("No football player found");
        }

    }
}
