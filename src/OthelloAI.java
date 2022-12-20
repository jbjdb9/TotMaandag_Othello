import java.io.IOException;

public class OthelloAI {
    public static int[] move() throws IOException {
        int[] move = {0,0};
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
        // Maakt een lijst van mogelijke zetten in format {{0, 2}, {4,3}} of {{col, row}}
        int[][] moves = new int[NumberofMoves()][2];
        int count = 0;
        for (int row=0; row<8; row++){
            for (int col=0; col<8;col++){
                if (OthelloReferee.validMove(new int[]{row, col})){
                    moves[count][0] = col;
                    moves[count][1] = row;
                    count++;
                }
            }
        }
        return moves;
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

