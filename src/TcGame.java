import java.util.Random;

public class TcGame {
    static int playerOne;
    static int playerTwo;
    static int turn;
    static boolean gameWin;

    static public void loop() {
        // Set the turn
        Random rng = new Random();
        turn = rng.nextInt(1, 3);
        // Print the board
        TcBoard.print();
        // Welcome the players, notify them who starts and who is playing as what.
        Announcer.welcome(turn, playerOne, playerTwo);
        while (!gameWin) {
            // Match with an opponent if we are playing remote and are not in game.
            if (Play.remote && !Remote.inGame) {
                Remote.match();
            }

            // Correct player makes a move
            if (turn == 1) {
                System.out.println("Player One is up!");
                switch (playerOne) {
                    case 0 -> Human.move();
                    case 1 -> TcAI.move();
                }
            } else {
                System.out.println("Player Two is up!");
                switch (playerTwo) {
                    case 0 -> Human.move();
                    case 1 -> TcAI.move();
                    case 2 -> Remote.move();
                }
            }

            // Print the board
            TcBoard.print();

            // End the game
            gameWin = TcReferee.win(TcBoard.board);
            if (gameWin && turn == 1) {
                Announcer.winner(1);
                Remote.inGame = false;
                if (!Play.remote) {
                    break;
                }
            }
            if (gameWin && turn == 2) {
                Announcer.winner(2);
                Remote.inGame = false;
                if (!Play.remote) {
                    break;
                }
            }
            if (TcReferee.tie()) {
                Announcer.winner(3);
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
