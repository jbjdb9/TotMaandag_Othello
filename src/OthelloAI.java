import java.awt.desktop.ScreenSleepEvent;
import java.io.IOException;
public class OthelloAI {
    static int[][] pointboard = {{10, -5, 3, 3, 3, 3, -5, 10},
            {-5, -5, -2, -2, -2, -2, -5, -5},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {-5, -5, -2, -2, -2, -2, -5, -5},
            {10, -5, 3, 3, 3, 3, -5, 10}};

    public static int[] Max(int[][] positions) {
        int[] bestmove = {positions[0][0], positions[0][1], positions[0][2]};
        for (int pos = 0; pos < positions.length - 1; pos++) {
            if (bestmove[2] < positions[pos][2]) {
                bestmove = new int[]{positions[pos][0], positions[pos][1], positions[pos][2]};
            }
        }
        return bestmove;
    }

    public static int[] Min(int[][] positions) {
        int[] bestmove = {positions[0][0], positions[0][1], positions[0][2]};
        for (int pos = 0; pos < positions.length - 1; pos++) {
            if (bestmove[2] > positions[pos][2]) {
                bestmove = new int[]{positions[pos][0], positions[pos][1], positions[pos][2]};
            }
        }
        return bestmove;
    }
    public static int MiniMax(int[] position, int depth, boolean maxiPlayer, int[][] board){
        int[][] children = getPossibleMoves(board);
        if (depth == 0 || children.length == 0){
            return pointboard[position[0]][position[1]] + ReturnScore(position, board);
        }
        if (maxiPlayer){

        }
    }
    public static int[] move() throws IOException {
        int score = 0;
        int bestScore = 0;
        int[] position = {0,0};
        int[] bestPosition = {0,0};

        int[][] positions = getPossibleMoves(OthelloBoard.board);
        for (int index = 0; index < positions.length; index++){
            position[0] = positions[index][0];
            position[1] = positions[index][1];
            int[][] board = OthelloBoard.board;

            // Aanpassen voor checks! Minimax/AlphaBeta/Random
            score = MiniMax(position, 3, true, board);

            if (score > bestScore){
                bestScore = score;
                bestPosition = position;
            }
        }

        System.out.println("De AI had als zet: " + PositionTranslate(bestPosition) + (bestPosition[0] + 1));
        if (Play.remote) {
            Remote.reverseTranslate(bestPosition);
        }
        return bestPosition;
    }

    public static int NumberofMoves(int[][] board) {
        // Kijkt hoeveel zetten er mogelijk zijn
        int count = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (OthelloReferee.validMove(new int[]{row, col}, board)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] getPossibleMoves(int[][] board) {
        // Maakt een lijst van mogelijke zetten in format {{0, 2, 0}, {4 ,3 ,0 }} of {{col, row, score}}
        int[][] moves = new int[NumberofMoves(board)][3];
        int count = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (OthelloReferee.validMove(new int[]{row, col}, board)) {
                    moves[count][1] = col; //Y-0
                    moves[count][0] = row; //X-1
                    count++;
                }
            }
        }
        return moves;
    }

    public static char PositionTranslate(int[] position) {
        if (position[1] == 0) {
            return 'A';
        }
        if (position[1] == 1) {
            return 'B';
        }
        if (position[1] == 2) {
            return 'C';
        }
        if (position[1] == 3) {
            return 'D';
        }
        if (position[1] == 4) {
            return 'E';
        }
        if (position[1] == 5) {
            return 'F';
        }
        if (position[1] == 6) {
            return 'G';
        }
        if (position[1] == 7) {
            return 'H';
        }
        return '?';
    }

    public static int[][] moveScore(int[][] positions, int[][] board) {
        for (int count = 0; positions.length> count; count++) {
            positions[count][2] = pointboard[positions[count][0]][positions[count][1]];
            if (OthelloGame.turn == 1) {
                positions[count][2] = AIChecker.all_check(positions[count], OthelloGame.playerOne[1], board);
            } else {
                positions[count][2] = AIChecker.all_check(positions[count], OthelloGame.playerTwo[1], board);
            }

            System.out.println("score positie "+count+"; "+ positions[count][2]);
        }
        System.out.println("Aantal posities gevonden: " + positions.length);
        return positions;
    }

    public static int ReturnScore(int[] position, int[][] board){
        if (OthelloGame.turn == 1) {
            position[2] += AIChecker.all_check(position, OthelloGame.playerOne[1], board);
            return position[2];
        } else {
            position[2] += AIChecker.all_check(position, OthelloGame.playerTwo[1], board);
            return position[2];
        }
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

