import java.io.IOException;
import java.util.Random;

public class OthelloGame {
    static int[] move = {0,0};
    // player int list exists of: {player type, player colour, player stones}
    static int[] playerOne = {0, 0, 2, 30};
    static int[] playerTwo = {0, 0, 2, 30};
    static int turn;
    static boolean gameWin;

    static public void loop() throws IOException {
        // Set the turn
        //Random rng = new Random();
        //turn = rng.nextInt(1, 3);
        // Print the board

        // Set colour based on which player starts
        if (turn == 1){
            playerOne[1] = 1;
            playerTwo[1] = 2;
            System.out.println("Player One is Black. Player Two is White");
        } else{
            playerOne[1] = 2;
            playerTwo[1] = 1;
            System.out.println("Player One is White. Player Two is Black");
        }
        // Welcome the players, notify them who starts and who is playing as what.

        Announcer.welcome(turn, playerOne[0], playerTwo[0]);
        while (!gameWin) {
            // Print the board
            OthelloBoard.print();
            // Correct player makes a move
            if (turn == 1) {
                System.out.println("Player One is up!");
                switch (playerOne[0]) {
                    case 0 -> move = Human.othelloMove();
                    case 1 -> move = OthelloAI.move();
                }
            } else {
                System.out.println("Player Two is up!");
                switch (playerTwo[0]) {
                    case 0 -> move = Human.othelloMove();
                    case 1 -> move = OthelloAI.move();
                    case 2 -> move = Remote.translate();
                }
            }
            OthelloBoard.update(move);
            // End the game if no more moves are possible
            if (!OthelloReferee.possibleMove()){
                gameWin = true;
                int winner = OthelloReferee.win();
                Announcer.winner(winner);
                Remote.inGame = false;
                if (!Play.remote) {
                    break;
                }
            }

            // Move the turn to the next player
            if (turn == 2) {
                turn = 1;
            } else if (turn == 1) {
                turn = 2;
            }
        }
    }
}