import java.util.Scanner;

public class Play {
    static Scanner input = new Scanner(System.in);
    static boolean remote = false;
    static boolean replay = false;
    public static void main(String[] args) {
        System.out.println("Welcome to Othello!");

    }

    public static void remote() {
        System.out.println("Do you want to play local or remote? [local/remote]");
        String result = input.nextLine();
        switch (result.toLowerCase()){
            case "remote" -> {
                remote = true;
            }
            case "local" -> {
                remote = false;
            }
            default -> {
                System.out.println("Do you want to play local or remote? [local/remote]");
                remote();
            }
        }
    }

    public static void replay() {
        String result = input.nextLine();
        switch (result.toUpperCase()){
            case "Y" -> {
                System.out.println("Play again!");
                //Model.clearBoard();
                //gameWin = false;
            }
            case "N" -> {
                //playAgain = false;
                System.out.println("Thank you for playing! See you next time!");
            }
            default -> {
                System.out.println("Do you want to play again? [Y/N]");
                replay();
            }
        }
    }
}