import java.io.IOException;
import java.util.Scanner;

public class Play {
    static Scanner input = new Scanner(System.in);
    static boolean remote;
    static boolean replay = true;
    public static void main(String[] args) throws IOException {
        while(replay){
            menu();
            // Connect if playing with a remote player
            if (remote){
                boolean connect = Connect.connect();
                if (!connect){
                    System.out.println("Connection or login failed. Closing program.");
                    break;
                }
            }
            TcGame.loop();
            replay();
        }
    }

    public static void menu() {
        System.out.println("How would you like to play?\n============================\n1 - Local Human vs Human\n2 - Local Human vs AI\n3 - Local AI vs AI\n4 - Remote as AI");
        String result = input.nextLine();
        switch (result){
            case "1" -> {
                remote = false;
                TcGame.playerOne = 0;
                TcGame.playerTwo = 0;
            }
            case "2" -> {
                remote = false;
                TcGame.playerOne = 0;
                TcGame.playerTwo = 1;
            }
            case "3" -> {
                remote = false;
                TcGame.playerOne = 1;
                TcGame.playerTwo = 1;
            }
            case "4" -> {
                remote = true;
                TcGame.playerOne = 1;
                TcGame.playerTwo = 2;
            }
            default -> menu();
        }
    }

    public static void replay() {
        String result = input.nextLine();
        switch (result.toUpperCase()){
            case "Y" -> {
                System.out.println("Play again!");
                TcBoard.clear();
                TcGame.gameWin = false;
            }
            case "N" -> {
                replay = false;
                System.out.println("Thank you for playing! See you next time!");
            }
            default -> {
                System.out.println("Do you want to play again? [Y/N]");
                replay();
            }
        }
    }
}