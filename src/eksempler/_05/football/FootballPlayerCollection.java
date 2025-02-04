package eksempler._05.football;

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
        // Get players with a minimum salary


    }
