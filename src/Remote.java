import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Remote{
    static boolean inGame = false;

    // Some way to handle the server telling you the match has ended !

    public static void move(){
        // WAIT for the server to present the opponent's move (handleInGame)
        // catch the remote player's move
        // update the board
    }
    public static void aiMoved(int move){
        // WAIT for the server to request a move (handleInGame)
        // send the move our AI made to the server
    }
    public static void match(){
        // WAIT for the sever to match you against another player (handleNotInGame)
        // Set inGame = true;
    }






//static Scanner input = new Scanner(System.in);
//static boolean gameWin = false;
//static boolean playAgain = true;
//static boolean remote = false;
//static boolean inGame = false;
//static boolean gameEnded = false;
//            if (connection != null) {
//        PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        System.out.println(login(out, in));
        // alles hierna, naar remote of weg
//        String response = null;
//        while (true) {
//            try {
//                response = in.readLine();
//            } catch (IOException e) {
                // Something fishy happened, ignore
//            }
//            if (response == null) {
                // Nothing yet, sleep 0.2 sec and continue
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
                    // Sleep interrupted, ignore
//                }
//                continue;
//            }
            // GAME LOOP MOET NAAR REMOTE (WAT HIERONDER STAAT)
            // We got a response! Parse and handle
//            String[] responseParts = response.split(" ");
//            String info = "";
//            if (response.contains("{")) {
//                info = response.substring(response.indexOf("{"));
//            }

            // Deal with the response appropriately
//            if (!inGame) {
                // Game not started yet
//                Remote.handleNotInGame(responseParts, info);
//            } else {
                // Already in a game
//                gameEnded = Remote.handleInGame(responseParts, info, out);
//            }
//            if (gameEnded) {
              // Game on for the next round!
//                inGame = false;
//                gameEnded = false;
//            }
//        }
//    }


    public static void handleNotInGame(String[] responseParts, String info) {
        //SVR GAME MATCH {PLAYERTOMOVE: "<naam speler1>", GAMETYPE: "<speltype>", OPPONENT: "<naam tegenstander>"}
        if (responseParts != null && responseParts[0].contains("MATCH") && info.contains("Othello")) {
            //inGame = true; ---- inGame functie moet eerst gemaakt worden
            // naam van ons team, moet gelijk zijn aan inlognaam
            if (info.contains(Connect.username)) {
                //Model.player = 0; ---- oude lijn vanuit tic-tac-toe. zet wie aan de beurt is onze ai of tegenstander (human)

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


