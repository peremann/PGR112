package eksempler._15.boardgame;

public record BoardGame(int id, String name, String type, int nrOfPlayers,
                        int minutes, int ageLimit, String imageUrl) {
}
