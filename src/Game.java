import java.util.Random;

public class Game {
    static int playerOne;
    static int playerTwo;
    static int turn;
    static boolean gameWin;

    static public void loop() {
            Random rng = new Random();
            turn = rng.nextInt(3) + 1;
            Board.print();
            welcome(turn);
            while (!gameWin) {
                if (turn == 2) {
                    turn = 1;
                } else if (turn == 1) {
                    turn = 2;
                }

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
                Board.print();

                gameWin = Referee.win(Board.board);
                if (gameWin && turn == 1) {
                    winner(1);
                    break;
                }
                if (gameWin && turn == 2) {
                    winner(2);
                    break;
                }
                if (Referee.tie()) {
                    winner(3);
                    break;
                }
            }
    }
    public static void welcome(int ins) {
        if (ins == 2) {
            System.out.println("Player One starts");
            switch(playerOne){
                case 0 -> System.out.println("They're controlled by a human");
                case 1 -> System.out.println("They're controlled by AI");
                case 2 -> System.out.println("They're controlled remotely");
            }
        } else if (ins == 1) {
            System.out.println("Player Two starts!");
            switch(playerTwo){
                case 0 -> System.out.println("They're controlled by a human");
                case 1 -> System.out.println("They're controlled by AI");
                case 2 -> System.out.println("They're controlled remotely");
            }
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
