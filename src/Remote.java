import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Remote{
    static boolean inGame = false;

    // Some way to handle the server telling you the match has ended !

    public static int move() throws IOException {
        boolean moved = false;
        String response = null;
        int numzet = 0;
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
            if (responseParts[0].contains("MOVE") && !info.contains(Connect.username)) {
                moved = true;
                int zet = info.lastIndexOf("MOVE: " + 2);
                numzet = (Integer.parseInt(info.substring(zet)));
            }
        }
        return numzet;
    }


    public static void aiMoved(int move) throws IOException{
        boolean ourmove = false;
        String response = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(Connect.connection.getInputStream()));
        PrintWriter out = new PrintWriter(Connect.connection.getOutputStream(), true);
        while (!ourmove) {
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
            if (responseParts[0].contains("YOURTURN")) {
                ourmove = true;
                out.println("move " + move);
                // WAIT for the server to request a move (handleInGame)
                // send the move our AI made to the server
            }
        }
}
    public static void subscribe() throws IOException {
        boolean ok = false;
        String response = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(Connect.connection.getInputStream()));
        PrintWriter out = new PrintWriter(Connect.connection.getOutputStream(), true);
        out.println("subscribe");
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
            String info = "";
            if (response.contains("{")) {
                info = response.substring(response.indexOf("{"));
            }
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
            }
            if (responseParts[0].contains("MATCH") && info.contains("TicTacToe")) {
                inGame = true;
                Play.game = 0;
                matched = true;
            } else if (responseParts[0].contains("MATCH") && info.contains("Othello")) {
                inGame = true;
                Play.game = 1;
                matched = true;
            }
        }
    }
}


