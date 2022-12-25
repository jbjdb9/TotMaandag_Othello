import java.awt.desktop.ScreenSleepEvent;
import java.io.IOException;
public class OthelloAI {
    public static int[] move() throws IOException {
        int[][] posmoves = PositionScore(getPossibleMoves());
        int [] move = AIMove(posmoves);
        System.out.println("De AI had als zet: " + PositionTranslate(move)+(move[0]+1));
        if (Play.remote){
            Remote.reverseTranslate(move);
        }

        return move;
    }
    public static int NumberofMoves(){
        // Kijkt hoeveel zetten er mogelijk zijn
        int count = 0;
        for (int row=0; row<8; row++){
            for (int col=0; col<8;col++){
                if (OthelloReferee.validMove(new int[]{row, col})){
                    count++;
                }
            }
        }
        return count;
    }
    public static int[][] getPossibleMoves(){
        // Maakt een lijst van mogelijke zetten in format {{0, 2, 0}, {4 ,3 ,0 }} of {{col, row, score}}
        int[][] moves = new int[NumberofMoves()][3];
        int count = 0;
        for (int row=0; row<8; row++){
            for (int col=0; col<8;col++){
                if (OthelloReferee.validMove(new int[]{row, col})){
                    moves[count][1] = col; //Y-0
                    moves[count][0] = row; //X-1
                    count++;
                }
            }
        }
        return moves;
    }
    public static int[] AIMove(int [][] positions){
        int [] bestmove = {positions[0][0], positions[0][1], positions[0][2]};
        for (int pos=0; pos<positions.length-1; pos++){
            if (bestmove[2]<positions[pos][2]){
                bestmove = new int[]{positions[pos][0], positions[pos][1], positions[pos][2]};
            }
        }
        return bestmove;
    }
    public static int[][] PositionScore(int[][] positions){
        for(int pos=0; pos<positions.length-1;pos++){
            //Hoeken
            if (positions[pos][0] == 0 && positions[pos][1] == 0){ //A1
                positions[pos][2] += 10;
            }
            if (positions[pos][0] == 7 && positions[pos][1] == 0){ //A8
                positions[pos][2] += 10;
            }
            if (positions[pos][0] == 0 && positions[pos][1] == 7){ //H1
                positions[pos][2] += 10;
            }
            if (positions[pos][0] == 7 && positions[pos][1] == 7){ //H8
                positions[pos][2] += 10;
            }
            // Hoeken om de hoeken
            // Hoek linksboven
            if (positions[pos][0] == 0 && positions[pos][1] == 1){ // A2
                positions[pos][2] -= 5;
            }
            if (positions[pos][0] == 1 && positions[pos][1] == 1){ // B2
                positions[pos][2] -= 5;
            }
            if (positions[pos][0] == 1 && positions[pos][1] == 0){ // B1
                positions[pos][2] -= 5;
            }

            // Hoek linksonder
            if (positions[pos][0] == 6 && positions[pos][1] == 0){ // A7
                positions[pos][2] -= 5;
            }
            if (positions[pos][0] == 6 && positions[pos][1] == 1){ // B7
                positions[pos][2] -= 5;
            }
            if (positions[pos][0] == 7 && positions[pos][1] == 1){ // B1
                positions[pos][2] -= 5;
            }

            // Hoek rechtsboven
            if (positions[pos][0] == 0 && positions[pos][1] == 6){ // G1
                positions[pos][2] -= 5;
            }
            if (positions[pos][0] == 1 && positions[pos][1] == 6){ // G2
                positions[pos][2] -= 5;
            }
            if (positions[pos][0] == 1 && positions[pos][1] == 7){ // H2
                positions[pos][2] -= 5;
            }

            // Hoek rechtsonder
            if (positions[pos][0] == 6 && positions[pos][1] == 6){ // G7
                positions[pos][2] -= 5;
            }
            if (positions[pos][0] == 6 && positions[pos][1] == 7){ // G8
                positions[pos][2] -= 5;
            }
            if (positions[pos][0] == 7 && positions[pos][1] == 6){ // G8
                positions[pos][2] -= 5;
            }
///////////////////////////////////////////////////////////////////////////////////
            // Stroken buitenkant boven horizontaal
            for (int place=2;place<6;place++){ // C1 t/m F1
                if (positions[pos][0] == 0 && positions[pos][1] == place){
                    positions[pos][2] +=  3;
                }
            }
            // Stroken buitenkant onder horizontaal
            for (int place=2;place<6;place++){ // C8 t/m F8
                if (positions[pos][0] == 7 && positions[pos][1] == place){
                    positions[pos][2] +=  3;
                }
            }

            // Stroken buitenkant links verticaal
            for (int place=2;place<6;place++){ // A3 t/m A6
                if (positions[pos][0] == place && positions[pos][1] == 0){
                    positions[pos][2] +=  3;
                }
            }

            // Stroken buitenkant rechts verticaal
            for (int place=2;place<6;place++){ // H3 t/m H6
                if (positions[pos][0] == place && positions[pos][1] == 7){
                    positions[pos][2] +=  3;
                }
            }
//////////////////////////////////////////////////////////////////////////////////////
            // Stroken binnen aan de buitenkant boven
            for (int place=2;place<6;place++){ // C2 t/m F2
                if (positions[pos][0] == 1 && positions[pos][1] == place){
                    positions[pos][2] -=  3;
                }
            }
            // Stroken binnen aan de onderkant boven
            for (int place=2;place<6;place++){ // C7 t/m F7
                if (positions[pos][0] == 6 && positions[pos][1] == place){
                    positions[pos][2] -=  3;
                }
            }
            // Stroken binnen aan de zijkant links
            for (int place=2;place<6;place++){ // B3 t/m B6
                if (positions[pos][0] == place && positions[pos][1] == 1){
                    positions[pos][2] -=  3;
                }
            }
            // Stroken binnen aan de zijkant rechts
            for (int place=2;place<6;place++){ // G3 t/m G6
                if (positions[pos][0] == place && positions[pos][1] == 6){
                    positions[pos][2] -=  3;
                }
            }
        }
        return positions;
    }
    public static char PositionTranslate(int[] position){
        if (position[1] == 0){
            return 'A';
        }
        if (position[1] == 1){
            return 'B';
        }
        if (position[1] == 2){
            return 'C';
        }
        if (position[1] == 3){
            return 'D';
        }
        if (position[1] == 4){
            return 'E';
        }
        if (position[1] == 5){
            return 'F';
        }
        if (position[1] == 6){
            return 'G';
        }
        if (position[1] == 7){
            return 'H';
        }
        return '?';
    }
}
// MinMax-Algoritme bevindingen.
//  - Als er een zet gedaan kan worden in de hoeken (A1, A8, H1, H8) heeft dit de grootste prioriteit.
//    Dit is namelijk zo omdat dit ervoor zorgt dat je het veld vanuit die hoek kan beheersen.
//  - Om zo'n hoek in handen te krijgen hebben een set-up nodig. Een steen in het midden van het bord
//    die ervoor zorgt dat de steen in de hoek van ons kan worden.
//  - Een zet om de hoek heen anders genoemd "de dodehoek" (in het geval van hoek A1 zijn dat B1, A2 en B2.) moeten kosten wat kost voorkomen worden.
//    Hierdoor kan de tegenstander de hoek krijgen en zijn we de lul. Othello is oorlog mensen vergeet dat niet!!!
//  - Het is ook van belang om het midden te beheren. Vanuit daar kunnen we makkelijker zetten doen om zijkanten
//    en hoeken te pakken.
//  - De Zijkanten zijn minder van belang zolang er maar een steen van ons tussen ligt anders is blokkeren in
//    de beste optie.

