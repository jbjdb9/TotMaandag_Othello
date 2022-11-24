import java.util.Random;

public class Game {
    static int playerOne;
    static int playerTwo;
    static int turn;
    static boolean gameWin;

    static public void loop() {
            // Set the turn
            Random rng = new Random();
            turn = rng.nextInt(1,3);
            // Print the board
            Board.print();
            // Welcome the players, notify them who starts and who is playing as what.
            welcome(turn);
            while (!gameWin) {
                // Match with an opponent if we are playing remote and are not in game.
                if (Play.remote && !Remote.inGame){
                    Remote.match();
                }

                // Correct player makes a move
                if (turn == 1){
                    System.out.println("Player One is up!");
                    switch(playerOne){
                        case 0 -> Human.move();
                        case 1 -> AI.move();
                    }
                } else {
                    System.out.println("Player Two is up!");
                    switch(playerTwo){
                        case 0 -> Human.move();
                        case 1 -> AI.move();
                        case 2 -> Remote.move();
                    }
                }

                // Print the board
                Board.print();

                // End the game
                gameWin = Referee.win(Board.board);
                if (gameWin && turn == 1) {
                    winner(1);
                    Remote.inGame = false;
                    if (!Play.remote){
                        break;
                    }
                }
                if (gameWin && turn == 2) {
                    winner(2);
                    Remote.inGame = false;
                    if (!Play.remote){
                        break;
                    }
                }
                if (Referee.tie()) {
                    winner(3);
                    Remote.inGame = false;
                    if (!Play.remote){
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
    public static void welcome(int turn) {
        switch(playerOne){
            case 0 -> System.out.println("Player One is controlled by a human");
            case 1 -> System.out.println("Player One is controlled by AI");
            case 2 -> System.out.println("Player One is controlled remotely");
        }
        switch(playerTwo){
            case 0 -> System.out.println("Player Two is controlled by a human");
            case 1 -> System.out.println("Player Two is controlled by AI");
            case 2 -> System.out.println("Player Two is controlled remotely");
        }
        if (turn == 1) {
            System.out.println("Player One starts");
        } else if (turn == 2) {
            System.out.println("Player Two starts!");
        }
    }
    public static void winner(int won) {
        switch(won){
            case 1 -> System.out.println("Player One Wins!");
            case 2 -> System.out.println("Player Two Wins!");
            case 3 -> System.out.println("It's a Tie!");
        }
    }
}
