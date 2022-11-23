import java.io.PrintWriter;

public class Remote {




    public static void handleNotInGame(String[] responseParts, String info) {
        //SVR GAME MATCH {PLAYERTOMOVE: "<naam speler1>", GAMETYPE: "<speltype>", OPPONENT: "<naam tegenstander>"}
        if (responseParts != null && responseParts[0].contains("MATCH") && info.contains("Othello")) {
            //inGame = true; ---- inGame functie moet eerst gemaakt worden
            // naam van ons team, moet gelijk zijn aan inlognaam
            if (info.contains("itv2ag1")) {
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

        else if (responseParts != null && responseParts[0].contains("MOVE") && !info.contains("itv2ag1")) {
            //Model.player = 0; ---- zelfde als voorgaande
            int zet = info.lastIndexOf("MOVE: " + 2);
            //Model.updateBoard(Integer.parseInt(info.substring(zet))); ---- zet de move van tegenstander in het board, hangt af van benaming rest code
        }
        return true;

    }
}
