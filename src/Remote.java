import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Remote {
    static boolean inGame = false;
    static Scanner input = new Scanner(System.in);

    // Some way to handle the server telling you the match has ended !

    public static int move() throws IOException {
        boolean moved = false;
        String response = null;
        int move = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(Connect.connection.getInputStream()));
        while (!moved) {
            try {
                response = in.readLine();
            } catch (IOException e) {
                // Something fishy happened, ignore
            }
            if (response == null) {
                // Nothing yet, sleep 0.1 sec and continue
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Sleep interrupted, ignore
                }
                continue;
            }
            String[] responseParts = response.split(" ");
            String info = "";
            if (response.contains("{")) {
                info = response.substring(response.indexOf("{"));
            }
            System.out.println(info);
            System.out.println(responseParts[0]);
            if (!info.contains(Connect.username)) {
                moved = true;
                int zet = info.lastIndexOf("MOVE: " + 2);
                //zet lezen gaat hier niet goed.
                System.out.println(zet);
                move = (Integer.parseInt(info.substring(zet)));
                System.out.println(move);
            }
        }
        return move;
    }

    public static int[] translate() throws IOException {
        int [] move = {-1, -1};
        int col = (move() / 8);
        int row = (move() % 8);
        move[0] = col;
        move[1] = row;
        return move;
    }

    public static void reverseTranslate(int[] move) throws IOException {
        int col = (move[1] * 8);
        int row = (move[0]);
        aiMoved(row + col);
    }

    public static void aiMoved(int move) throws IOException {
        boolean ourMove = false;
        String response = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(Connect.connection.getInputStream()));
        PrintWriter out = new PrintWriter(Connect.connection.getOutputStream(), true);
        while (!ourMove) {
            try {
                response = in.readLine();
            } catch (IOException e) {
                // Something fishy happened, ignore
            }
            if (response == null) {
                // Nothing yet, sleep 0.1 sec and continue
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Sleep interrupted, ignore
                }
                continue;
            }
            String[] responseParts = response.split(" ");
            ourMove = true;
            out.println("move " + move);
            // WAIT for the server to request a move (handleInGame)
            // send the move our AI made to the server

        }
    }

    public static void subscribe() throws IOException {
        boolean ok = false;
        String response = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(Connect.connection.getInputStream()));
        PrintWriter out = new PrintWriter(Connect.connection.getOutputStream(), true);
        System.out.println("what would you like to play?\n=================================\n1 - TicTacToe\n2 - Othello");
        String game = input.nextLine();
        if (game.equals("1")) {
            out.println("subscribe tic-tac-toe");
        } else if (game.equals("2")) {
            out.println("subscribe reversi");
        }
        while (!ok) {
            try {
                response = in.readLine();
            } catch (IOException e) {
                // Something fishy happened, ignore
            }
            if (response == null) {
                // Nothing yet, sleep 0.1 sec and continue
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Sleep interrupted, ignore
                }
                continue;
            }
            String[] responseParts = response.split(" ");
            if (responseParts[0].contains("OK")) {
                ok = true;
                // wait for server to respond
            }
        }
        match();

    }

    public static void match() throws IOException {
        boolean matched = false;
        String response = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(Connect.connection.getInputStream()));
        while (!matched) {
            try {
                response = in.readLine();
            } catch (IOException e) {
                // Something fishy happened, ignore
            }
            if (response == null) {
                // Nothing yet, sleep 0.1 sec and continue
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Sleep interrupted, ignore
                }
                continue;
            }
            String[] responseParts = response.split(" ");
            String info = "";
            if (response.contains("{")) {
                info = response.substring(response.indexOf("{"));
                System.out.println(info);
                System.out.println("hoi");
                System.out.println(responseParts[0]);
            }
            if (info.contains("TicTacToe")) {
                inGame = true;
                Play.game = 0;
                matched = true;
                System.out.println("hallo");
//                if (info.contains(Connect.username)) {
//                    wij beginnen
//                } else {
//                        tegenstander begint

            } else if (info.contains("Reversi")) {
                inGame = true;
                Play.game = 1;
                matched = true;
                System.out.println("hallo");
                if (info.contains(Connect.username)) {
                    OthelloGame.turn = 1;
                } else {
                    OthelloGame.turn = 2;
                }
            }
        }
    }
}


