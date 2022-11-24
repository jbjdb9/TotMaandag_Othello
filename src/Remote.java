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
        // WAIT for the server to present the opponent's move (handleInGame)
        // catch the remote player's move
        // update the board

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



    public static void handleNotInGame(String[] responseParts, String info) {
        //SVR GAME MATCH {PLAYERTOMOVE: "<naam speler1>", GAMETYPE: "<speltype>", OPPONENT: "<naam tegenstander>"}
        if (responseParts != null && responseParts[0].contains("MATCH") && info.contains("TicTacToe")) {
            inGame = true; //---- inGame functie moet eerst gemaakt worden
            //
        if (responseParts != null && responseParts[0].contains("MATCH") && info.contains("Othello")) {


            }
            else {
                //Model.player = 1; ---- zelfde als if statement

            }
        }
    }

    public static boolean handleInGame(String[] responseParts, String info, PrintWriter out) {
        //SVR GAME YOURTURN {TURNMESSAGE: "<bericht voor deze beurt>"}
        if (responseParts != null && responseParts[0].contains("YOURTURN")) {
            //Model.player = 1;  ---- zelfde als voorgaande
            //int move = AI.aiMove(); ---- roept ai aan om zet te doen, alleen aanroep functie verandert afhangend van naam
            //out.println("move " + move); ---- stuur move door naar server, move naam hangt af van hoe we die in ai noemen
        }

        //overbodige case, case eronder vangt deze al op (nog laten staan voor test)
        //SVR GAME MOVE {PLAYER: "<speler>", DETAILS: "<reactie spel op zet>", MOVE: "<zet>"}
        //else if (responseParts != null && responseParts[0].contains("MOVE") && info.contains("itv2ag1")) {
        //Model.player = 0;
        //}

        else if (responseParts != null && responseParts[0].contains("MOVE") && !info.contains(Connect.username)) {
            //Model.player = 0; ---- zelfde als voorgaande
            int zet = info.lastIndexOf("MOVE: " + 2);
            //Model.updateBoard(Integer.parseInt(info.substring(zet))); ---- zet de move van tegenstander in het board, hangt af van benaming rest code
        }
        return true;

    }
}


