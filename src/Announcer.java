public class Announcer {
    public static void welcome(int turn, int playerOne, int playerTwo) {
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
