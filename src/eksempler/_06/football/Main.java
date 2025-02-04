package eksempler._06.football;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
            1. Move creation of players to FootballPlayerCollection
            2. Create a class FootballProgram with a public method menu()
            3. The method should contain a menu with these items:
                a. see all players
                b. addPlayer
                c. quit
            4. Test that it works!
            5. Use the debugger in the addPlayerMethod.
        */


        // Figure out how much they earn in total
        FootballPlayerCollection fpc = new FootballPlayerCollection();
        fpc.initPlayers();

        FootballProgram program = new FootballProgram();
        program.setFpc(fpc);
        program.menu();
    }
}
