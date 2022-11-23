import java.io.PrintWriter;

public class Connect {
}




    public static void handleNotInGame(String[] responseParts, String info) {
        //SVR GAME MATCH {PLAYERTOMOVE: "<naam speler1>", GAMETYPE: "<speltype>", OPPONENT: "<naam tegenstander>"}
        if (responseParts != null && responseParts[0].contains("MATCH") && info.contains("Othello")) {
            //inGame = true;
            // naam van ons team, moet gelijk zijn aan inlognaam
            if (info.contains("itv2ag1")) {
                //Model.player = 0;

            }
            else {
                //Model.player = 1;

            }
        }
    }

    public static boolean handleInGame(String[] responseParts, String info, PrintWriter out) {
        //SVR GAME YOURTURN {TURNMESSAGE: "<bericht voor deze beurt>"}
        if (responseParts != null && responseParts[0].contains("YOURTURN")) {
            //Model.player = 1;
            //int move = AI.aiMove();
            //out.println("move " + move);
        }

        //overbodige case, case eronder vangt deze al op (nog laten staan voor test)
        //SVR GAME MOVE {PLAYER: "<speler>", DETAILS: "<reactie spel op zet>", MOVE: "<zet>"}
        //else if (responseParts != null && responseParts[0].contains("MOVE") && info.contains("itv2ag1")) {
        //Model.player = 0;
        //}

        else if (responseParts != null && responseParts[0].contains("MOVE") && !info.contains("itv2ag1")) {
            //Model.player = 0;
            //int zet = info.lastIndexOf("MOVE: " + 2);
            //Model.updateBoard(Integer.parseInt(info.substring(zet)));
        }
        return true;

    }
}
        //OK (jouw beurt voor een zet)

        //SVR GAME <speler resultaat> {PLAYERONESCORE: "<score speler1>", PLAYERTWOSCORE: "<score speler2>", COMMENT: "<commentaar op resultaat>"}
