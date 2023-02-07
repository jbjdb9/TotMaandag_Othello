import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OthelloAI {
    static int[][] pointBoard = {{10, -5, 3, 3, 3, 3, -5, 10},
            {-5, -5, -2, -2, -2, -2, -5, -5},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {3, -2, 0, 0, 0, 0, -2, 3},
            {-5, -5, -2, -2, -2, -2, -5, -5},
            {10, -5, 3, 3, 3, 3, -5, 10}};

    public static int miniMax(int[] position, int depth, boolean maxiPlayer, int[][] board, int turn) {
        OthelloBoard.update(position, board, turn);
        turn = turnSwitch(turn);
        int[][] children = OthelloBoard.getPossibleMoves(board, turn);
        if (depth == 0 || children.length == 0) {
            return pointBoard[position[0]][position[1]] + returnScore(position, board);
        }
        if (maxiPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int[] child : children) {
                board = boardCopy(board);
                int eval = miniMax(child, depth - 1, false, board, turn);
                maxEval = Math.max(eval, maxEval);
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int[] child : children) {
                board = boardCopy(board);
                int eval = miniMax(child, depth - 1, true, board, turn);
                minEval = Math.min(eval, minEval);
            }
            return minEval;
        }
    }

    public static int alphaBeta(int[] position, int depth, int alpha, int beta, boolean maxiPlayer, int[][] board, int turn) {
        OthelloBoard.update(position, board, turn);
        turn = turnSwitch(turn);
        int[][] children = OthelloBoard.getPossibleMoves(board, turn);
        if (depth == 0 || children.length == 0) {
            return pointBoard[position[0]][position[1]] + returnScore(position, board);
        }
        if (maxiPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int[] child : children) {
                board = boardCopy(board);
                int eval = alphaBeta(child, depth - 1, alpha, beta, false,  board, turn);
                maxEval = Math.max(eval, maxEval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int[] child : children) {
                board = boardCopy(board);
                int eval = alphaBeta(child, depth - 1, alpha, beta, true,  board, turn);
                minEval = Math.min(eval, minEval);
                beta = Math.min(beta, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }

    public static int randomAI() {
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
        int[] bestPosition = {0, 0};

        int[][] positions = OthelloBoard.getPossibleMoves(OthelloBoard.board, turn);
        for (int[] ints : positions) {
            int[][] board = boardCopy(OthelloBoard.board);

            // Aanpassen voor checks!
            // score = miniMax(ints, 5, true, board, turn); // Max depth: 5
            score = alphaBeta(ints, 9, Integer.MIN_VALUE , Integer.MAX_VALUE, true, board, turn); // Max depth 9
            // score = randomAI();

            if (score > bestScore) {
                bestScore = score;
                bestPosition = ints;
            }
        }

        System.out.println("De AI had als zet: " + PositionTranslate_inta_str(bestPosition));
        if (Play.remote) {
            Remote.reverseTranslate(bestPosition);
        }
        return bestPosition;
    }
    public static int[] moveTimer() throws IOException {
        int turn = OthelloGame.turn;
        int score;
        int bestScore = Integer.MIN_VALUE;
        int[] bestPosition = {0, 0};
        int[][] positions = OthelloBoard.getPossibleMoves(OthelloBoard.board, turn);
        final boolean[] timeUp = {false};

        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                timeUp[0] = true;
                System.out.println("Time is up!");
            }
        };

        timer.schedule(task, 4000);

        for (int[] ints : positions) {
            int[][] board = boardCopy(OthelloBoard.board);

            score = alphaBeta(ints, 10, Integer.MIN_VALUE , Integer.MAX_VALUE, true, board, turn); // Max depth 10

            if (score > bestScore) {
                bestScore = score;
                bestPosition = ints;
            }

            if (timeUp[0]){
                break;
            }
        }
        timer.cancel();

        System.out.println("De AI had als zet: " + PositionTranslate_inta_str(bestPosition));
        if (Play.remote) {
            Remote.reverseTranslate(bestPosition);
        }
        return bestPosition;
    }

    public static String PositionTranslate_inta_str(int[] position) {
        if (position[1] == 0) {
            return "A" + (position[0] + 1);
        }
        if (position[1] == 1) {
            return "B" + (position[0] + 1);
        }
        if (position[1] == 2) {
            return "C" + (position[0] + 1);
        }
        if (position[1] == 3) {
            return "D" + (position[0] + 1);
        }
        if (position[1] == 4) {
            return "E" + (position[0] + 1);
        }
        if (position[1] == 5) {
            return "F" + (position[0] + 1);
        }
        if (position[1] == 6) {
            return "G" + (position[0] + 1);
        }
        if (position[1] == 7) {
            return "H" + (position[0] + 1);
        }
        return "?";
    }
    public static int[] PositionTranslate_str_inta(String position){
        if (position.charAt(0) == 'A'){
            return new int[]{position.charAt(1)-49, 0};
        }
        if (position.charAt(0) == 'B'){
            return new int[]{position.charAt(1)-49, 1};
        }
        if (position.charAt(0) == 'C'){
            return new int[]{position.charAt(1)-49, 2};
        }
        if (position.charAt(0) == 'D'){
            return new int[]{position.charAt(1)-49, 3};
        }
        if (position.charAt(0) == 'E'){
            return new int[]{position.charAt(1)-49, 4};
        }
        if (position.charAt(0) == 'F'){
            return new int[]{position.charAt(1)-49, 5};
        }
        if (position.charAt(0) == 'G'){
            return new int[]{position.charAt(1)-49, 6};
        }
        if (position.charAt(0) == 'H'){
            return new int[]{position.charAt(1)-49, 7};
        }
        else {
            return new int[]{0,0};
        }
    }

    public static int returnScore(int[] position, int[][] board) {
        int score = 0;
        if (OthelloGame.turn == 1) {
            score += AIChecker.all_check(position, OthelloGame.playerOne[1], board);
        } else {
            score += AIChecker.all_check(position, OthelloGame.playerTwo[1], board);
        }
        return score;
    }

    public static int[][] boardCopy(int[][] board) {
        int[][] board_copy = new int[8][8];
        for (int row = 0; row < 8; row++) {
            System.arraycopy(board[row], 0, board_copy[row], 0, 7);
        }
        return board_copy;
    }
}