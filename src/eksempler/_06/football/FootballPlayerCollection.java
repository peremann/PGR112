package eksempler._06.football;

import java.util.ArrayList;

public class FootballPlayerCollection {
    private ArrayList<FootballPlayer> players;

    public ArrayList<FootballPlayer> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<FootballPlayer> players) {
        this.players = players;
    }

    public void addPlayer(FootballPlayer player) {
        players.add(player);
    }

    public FootballPlayer getPlayer(String name) {
        for (FootballPlayer player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public int computeSalary() {
        int sum = 0;
        for (int i = 0; i < players.size(); i++) {
            sum += players.get(i).getSalary();
        }
        return sum;
    }

    // Answer: How many players in collection.
    public int getNumberOfPlayers() {
        return players.size();
    }

    // Remove player
    public boolean removePlayerByName(String name) {
        for (FootballPlayer player : players) {
            if (player.getName().equals(name)) {
                players.remove(player);
                return true;
            }
        }
        return false;
    }

    public boolean removePlayer(FootballPlayer playerToRemove) {
        return players.remove(playerToRemove);
    }

    public void initPlayers(){
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
        players = new ArrayList<>();
        players.add(footballPlayer1);
        players.add(footballPlayer2);
        players.add(footballPlayer3);
        setPlayers(players);
    }
}
