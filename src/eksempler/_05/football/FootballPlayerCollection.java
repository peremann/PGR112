package eksempler._05.football;

import java.util.ArrayList;

public class FootballPlayerCollection {
    // Add field footballPlayers (ArrayList)
    private ArrayList<FootballPlayer> players;
    // Add getter and setter
    public ArrayList<FootballPlayer> getPlayers(){
        return this.players;
    }

    public void setPlayers(ArrayList<FootballPlayer> players) {
        this.players = players;
    }

    // Add methods addPlayer, getPlayer(String name), totalSalary
    public void addPlayer(FootballPlayer player) {
        players.add(player);
    }

    public FootballPlayer getPlayer(String name){
        for (FootballPlayer player : players) {
            if(player.getName().equalsIgnoreCase(name)){
                return player;
            }
        }
        return null;
    }

    // Get players with a minimum wage


    public int computeSalary(){
        int sum = 0;
        for (int i = 0; i < players.size(); i++) {
            sum += players.get(i).getSalary();
        }
        return sum;
    }
}
