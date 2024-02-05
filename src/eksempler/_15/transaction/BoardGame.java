package eksempler._15.transaction;

public record BoardGame(int id, String name, String type, int nrOfPlayers,
                        int minutes, int ageLimit, String imageUrl) {
}
