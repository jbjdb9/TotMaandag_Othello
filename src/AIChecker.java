public class AIChecker {

    public static int all_check(int[]move, int color, int[][]board){
        int score = 0;
        score += north_counter(move, color, board);
        score += northeast_counter(move, color, board);
        score += east_counter(move, color, board);
        score += southeast_counter(move, color, board);
        score += southwest_counter(move, color, board);
        score += west_counter(move, color, board);
        score +=northwest_counter(move, color, board);
        return score;
    }
    public static int north_counter(int[]move, int color, int[][]board){
        // Checkt of stenen geflipt kunnen worden naar noord.
        int place = move[0];
        int steps = 0;
        while(place != 0){
            if(board[place-1][move[1]] == 0){
                return 0;
            }
            else if (board[place-1][move[1]] == color) {
                return steps; // make sure we met an enemy stone first
            }
            steps++;
            place--;
        }
        return 0;
    }
    public static int northeast_counter(int[] move, int color, int[][]board){
        // Checkt of stenen geflipt kunnen worden naar noordoost.
        int place_x = move[1];
        int place_y = move[0];
        int steps = 0;
        while (place_y != 0 && place_x != 7){
            if (board[place_y-1][place_x+1] == 0){
                return 0;
            }
            else if (board[place_y-1][place_x+1] == color) {
                return steps; // make sure we met an enemy stone first
            }
            steps++;
            place_x++;
            place_y--;
        }
        return 0;
    }
    public static int east_counter(int[]move, int color, int[][]board){
        // Checkt of stenen geflipt kunnen worden naar oost.
        int place = move[1];
        int steps = 0;
        while(place != 7){
            if(board[move[0]][place+1] == 0){
                return 0;
            }
            else if (board[move[0]][place+1] == color) {
                return steps; // make sure we met an enemy stone first
            }
            steps++;
            place++;
        }
        return 0;
    }
    public static int southeast_counter(int[] move, int color, int[][]board){
        // Checkt of stenen geflipt kunnen worden naar zuidoost.
        int place_x = move[1];
        int place_y = move[0];
        int steps = 0;
        while (place_y != 7 && place_x != 7){
            if (board[place_y+1][place_x+1] == 0){
                return 0;
            }
            else if (board[place_y+1][place_x+1] == color) {
                return steps; // make sure we met an enemy stone first
            }
            steps++;
            place_x++;
            place_y++;
        }
        return 0;
    }
    public static int south_counter(int[]move, int color, int[][]board){
        // Checkt of stenen geflipt kunnen worden naar zuid.
        int place = move[0];
        int steps = 0;
        while(place != 7){
            if(board[place+1][move[1]] == 0){
                return 0;
            }
            else if (board[place+1][move[1]] == color) {
                return steps; // make sure we met an enemy stone first
            }
            steps++;
            place++;
        }
        return 0;
    }
    public static int southwest_counter(int[] move, int color, int[][]board){
        // Checkt of stenen geflipt kunnen worden naar zuidwest.
        int place_x = move[1];
        int place_y = move[0];
        int steps = 0;
        while (place_y != 7 && place_x != 0){
            if (board[place_y+1][place_x-1] == 0){
                return 0;
            }
            else if (board[place_y+1][place_x-1] == color) {
                return steps; // make sure we met an enemy stone first
            }
            steps++;
            place_x--;
            place_y++;
        }
        return 0;
    }

    public static int west_counter(int[]move, int color, int[][]board){
        // Checkt of stenen geflipt kunnen worden naar west.
        int place = move[1];
        int steps = 0;
        while(place != 0){
            if(board[move[0]][place-1] == 0){
                return 0;
            }
            else if (board[move[0]][place-1] == color) {
                return steps; // make sure we met an enemy stone first
            }
            steps++;
            place--;
        }
        return 0;
    }

    public static int northwest_counter(int[] move, int color, int[][]board){
        // Checkt of stenen geflipt kunnen worden naar noordwest.
        int place_x = move[1];
        int place_y = move[0];
        int steps = 0;
        while (place_y != 0 && place_x != 0){
            if (board[place_y-1][place_x-1] == 0){
                return 0;
            }
            else if (board[place_y-1][place_x-1] == color) {
                return steps; // make sure we met an enemy stone first
            }
            steps++;
            place_x--;
            place_y--;
        }
        return 0;
    }
}
