import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class OthelloAI {
    static int[][] pointBoard = {{10, -5, 3, 3, 3, 3, -5, 10},
            {-5, -5, -2, -2, -2, -2, -5, -5},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {-5, -5, -2, -2, -2, -2, -5, -5},
            {10, -5, 3, 3, 3, 3, -5, 10}};

    public static int miniMax(int[] position, int depth, boolean maxiPlayer, int[][] board, int turn){
        OthelloBoard.update(position, board, turn);
        turn = turnSwitch(turn);
        int[][] children = OthelloBoard.getPossibleMoves(board, turn);
        if (depth == 0 || children.length == 0){
            return pointBoard[position[0]][position[1]] + returnScore(position, board);
        }
        if (maxiPlayer){
            int maxEval = Integer.MIN_VALUE;
            for (int[] child : children) {
                board = boardCopy(board);
                int eval = miniMax(child, depth - 1, false, board, turn);
                maxEval = Math.max(eval, maxEval);
            }
            return maxEval;
        }
        else {
            int minEval = Integer.MAX_VALUE;
            for (int[] child : children) {
                board = boardCopy(board);
                int eval = miniMax(child, depth - 1, true, board, turn);
                minEval = Math.min(eval, minEval);
            }
            return minEval;
        }
    }
    public static int alphaBeta(int[] position, int depth, int alpha, int beta, boolean maxiPlayer, int[][] board, int turn){
        OthelloBoard.update(position, board, turn);
        turn = turnSwitch(turn);
        int[][] children = OthelloBoard.getPossibleMoves(board, turn);
        if (depth == 0 || children.length == 0){
            return pointBoard[position[0]][position[1]] + returnScore(position, board);
        }
        if (maxiPlayer){
            int maxEval = Integer.MIN_VALUE;
            for (int[] child : children) {
                board = boardCopy(board);
                int eval = miniMax(child, depth - 1, false, board, turn);
                maxEval = Math.max(eval, maxEval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha){
                    break;
                }
            }
            return maxEval;
        }
        else {
            int minEval = Integer.MAX_VALUE;
            for (int[] child : children) {
                board = boardCopy(board);
                int eval = miniMax(child, depth - 1, true, board, turn);
                minEval = Math.min(eval, minEval);
                beta = Math.min(beta, eval);
                if (beta <= alpha){
                    break;
                }
            }
            return minEval;
        }
    }
    public static int randomAI(){
        Random rng = new Random();
        return rng.nextInt(1, 20);
    }
    public static int turnSwitch(int turn) {
        if (turn == 2) {
            return 1;
        } else {
            return 2;
        }
    }
    public static int[] move() throws IOException {
        int turn = OthelloGame.turn;
        int score;
        int bestScore = Integer.MIN_VALUE;
        int[] bestPosition = {0,0};

        int[][] positions = OthelloBoard.getPossibleMoves(OthelloBoard.board, turn);
        for (int[] ints : positions) {
            int[][] board = boardCopy(OthelloBoard.board);

            // Aanpassen voor checks!
            score = miniMax(ints, 8, true, board, turn);
            // score = alphaBeta(ints, 63, Integer.MIN_VALUE , Integer.MAX_VALUE, true, board, turn);
            // score = randomAI();

            if (score > bestScore) {
                bestScore = score;
                bestPosition = ints;
            }
        }

        System.out.println("De AI had als zet: " + PositionTranslate(bestPosition) + (bestPosition[0] + 1));
        if (Play.remote) {
            Remote.reverseTranslate(bestPosition);
        }
        return bestPosition;
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

    public static int returnScore(int[] position, int[][] board){
        int score = 0;
        if (OthelloGame.turn == 1) {
             score += AIChecker.all_check(position, OthelloGame.playerOne[1], board);
        } else {
            score += AIChecker.all_check(position, OthelloGame.playerTwo[1], board);
        }
        return score;
    }

    public static int[][] boardCopy(int[][] board){
        int[][] board_copy = new int[8][8];
        for (int row=0; row < 8; row++){
            System.arraycopy(board[row], 0, board_copy[row], 0, 7);
        }
        return board_copy;
    }
    public static void print(int[][] board){
        // Code for an underline
        System.out.print(" \u200E\u200E\u200E|\u200E\u200E\u200E\uD835\uDCD0 |\u200E\u200E\u200E\uD835\uDCD1 |\u200E\u200E\u200E\uD835\uDCD2 |\u200E\u200E\u200E\uD835\uDCD3 |\u200E\u200E\u200E\uD835\uDCD4 |\u200E\u200E\u200E\uD835\uDCD5 |\u200E\u200E\u200E\uD835\uDCD6 |\u200E\u200E\u200E\uD835\uDCD7 |");
        // Print the board
        for(int row = 0;row < 8;row++){
            System.out.println();
            System.out.print(row+1 + "|");
            for(int column = 0;column < 8;column++){
                if(board[row][column] != 0){
                    if(board[row][column] == 1){
                        System.out.print("⚫|");
                    } else{
                        System.out.print("⚪|");
                    }
                }
                else {
                    if (OthelloReferee.validMove(new int[]{row, column}, board, OthelloGame.turn)){
                        System.out.print("❎|");
                    }
                    else {
                        System.out.print("\uD83D\uDFE9|");
                    }

                }
            }
        }
        //❎
        // Code for an over line
        System.out.println("\n ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        // Code for a scoreboard
        System.out.println("- ⚫Black: " + OthelloReferee.scoreboard(1)+" | ⚪White: " + OthelloReferee.scoreboard(2)+" -");
        System.out.println();
    }
}
