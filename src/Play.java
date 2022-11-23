import java.util.Scanner;

public class Play {
    static Scanner input = new Scanner(System.in);
    static boolean remote;
    static boolean replay = true;
    public static void main(String[] args) {
        while(replay){
            menu();
//            if (remote){
//                boolean connect = Connect.connect();
//                if (!connect){
//                    System.out.println("Connection failed. Closing program.");
//                    break;
//                }
//            }
            Game.loop();
            replay();
        }
    }

    public static void menu() {
        System.out.println("How would you like to play?\n============================\n1 - Local Human vs Human\n2 - Local Human vs AI\n3 - Local AI vs AI\n4 - Remote as AI\n5 - Remote as Human");
        String result = input.nextLine();
        switch (result){
            case "1" -> {
                remote = false;
                Game.playerOne = 0;
                Game.playerTwo = 0;
            }
            case "2" -> {
                remote = false;
                Game.playerOne = 0;
                Game.playerTwo = 1;
            }
            case "3" -> {
                remote = false;
                Game.playerOne = 1;
                Game.playerTwo = 1;
            }
            case "4" -> {
                remote = true;
                Game.playerOne = 1;
                Game.playerTwo = 2;
            }
            case "5" -> {
                remote = true;
                Game.playerOne = 0;
                Game.playerTwo = 2;
            }
            default -> {
                menu();
            }
        }
    }

    public static void replay() {
        System.out.println("Do you want to play again? [Y/N]");
        String result = input.nextLine();
        switch (result.toUpperCase()){
            case "Y" -> {
                System.out.println("Play again!");
                Board.clear();
                Game.gameWin = false;
            }
            case "N" -> {
                replay = false;
                System.out.println("Thank you for playing! See you next time!");
            }
            default -> {
                replay();
            }
        }
    }
}