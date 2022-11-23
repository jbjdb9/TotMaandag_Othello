import java.util.Random;

public class Game {
    static int playerOne;
    static int playerTwo;
    static int turn;
    static boolean gameWin;

    static public void loop() {
        while (Play.replay) {
            Random rng = new Random();
            turn = rng.nextInt(3) + 1;
            Board.print();
            welcome(turn);
            while (!gameWin) {
                if (turn == 2) {
                    turn = 1;
                    //playerMove();
                } else if (turn == 1) {
                    turn = 2;
                    //ai.aiMove();
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
    }

    public static void welcome(int ins) {
        // Tell the user who is controlling the players !!!!!!!!!
        if (ins == 1) {
            System.out.println("Player One starts");
        } else if (ins == 2) {
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
