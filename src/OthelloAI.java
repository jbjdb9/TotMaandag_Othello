import java.io.IOException;
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
        int[][] children = OthelloBoard.getPossibleMoves(board);
        int[] pos = {0, 0};
        if (depth == 0 || children.length == 0){
            return pointBoard[position[0]][position[1]] + returnScore(position, board);
        }
        if (maxiPlayer){
            int maxEval = Integer.MIN_VALUE;
            for (int[] child : children) {
                pos[0] = child[0];
                pos[1] = child[1];
                OthelloBoard.update(child, board, turn);
                turn = turnSwitch(turn);
                int eval = miniMax(pos, depth - 1, false, board, turn);
                maxEval = Math.max(eval, maxEval);
            }
            return maxEval;
        }
        else {
            int minEval = Integer.MAX_VALUE;
            for (int[] child : children) {
                pos[0] = child[0];
                pos[1] = child[1];
                OthelloBoard.update(child, board, turn);
                turn = turnSwitch(turn);
                int eval = miniMax(pos, depth - 1, true, board, turn);
                minEval = Math.min(eval, minEval);
            }
            return minEval;
        }
    }
    public static int alphaBeta(int[] position, int depth, int alpha, int beta, boolean maxiPlayer, int[][] board, int turn){
        int[][] children = OthelloBoard.getPossibleMoves(board);
        int[] pos = {0, 0};
        if (depth == 0 || children.length == 0){
            return pointBoard[position[0]][position[1]] + returnScore(position, board);
        }
        if (maxiPlayer){
            int maxEval = Integer.MIN_VALUE;
            for (int[] child : children) {
                pos[0] = child[0];
                pos[1] = child[1];
                OthelloBoard.update(child, board, turn);
                turn = turnSwitch(turn);
                int eval = alphaBeta(pos, depth - 1, alpha, beta, false, board, turn);
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
                pos[0] = child[0];
                pos[1] = child[1];
                OthelloBoard.update(child, board, turn);
                turn = turnSwitch(turn);
                int eval = alphaBeta(pos, depth - 1, alpha, beta, true, board, turn);
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
        int[] position = {0,0};
        int[] bestPosition = {0,0};

        int[][] positions = OthelloBoard.getPossibleMoves(OthelloBoard.board);
        for (int[] ints : positions) {
            position[0] = ints[0];
            position[1] = ints[1];
            int[][] board = boardCopy();

            // Aanpassen voor checks! Minimax/AlphaBeta/Random
            // score = miniMax(position, 63, true, board, turn);
            score = alphaBeta(position, 63, Integer.MIN_VALUE , Integer.MAX_VALUE, true, board, turn);
            // score = randomAI();

            if (score > bestScore) {
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

    public static int[][] boardCopy(){
        int[][] board_copy = new int[8][8];
        for (int row=0; row < 8; row++){
            System.arraycopy(OthelloBoard.board[row], 0, board_copy[row], 0, 7);
        }
        return board_copy;
    }
}
