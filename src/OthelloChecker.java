public class OthelloChecker {
    // De klasse OthelloChecker kijkt of het mogelijk is om stenen te flippen.
    // Dit doet die voor elke richting en geeft voor elke richting een true of false terug.
    public static boolean north_checker(int[]move, int color, int[][] board){
        // Checkt of stenen geflipt kunnen worden naar noord.
        int place = move[0];
        int steps = 0;
        while(place != 0){
            if(board[place-1][move[1]] == 0){
                return false;
            }
            else if (board[place-1][move[1]] == color) {
                return steps != 0; // make sure we met an enemy stone first
            }
            steps++;
            place--;
        }
        return false;
    }
    public static boolean northeast_checker(int[] move, int color, int[][] board){
        // Checkt of stenen geflipt kunnen worden naar noordoost.
        int place_x = move[1];
        int place_y = move[0];
        int steps = 0;
        while (place_y != 0 && place_x != 7){
            if (board[place_y-1][place_x+1] == 0){
                return false;
            }
            else if (board[place_y-1][place_x+1] == color) {
                return steps != 0; // make sure we met an enemy stone first
            }
            steps++;
            place_x++;
            place_y--;
        }
        return false;
    }
    public static boolean east_checker(int[]move, int color, int[][] board){
        // Checkt of stenen geflipt kunnen worden naar oost.
        int place = move[1];
        int steps = 0;
        while(place != 7){
            if(board[move[0]][place+1] == 0){
                return false;
            }
            else if (board[move[0]][place+1] == color) {
                return steps != 0; // make sure we met an enemy stone first
            }
            steps++;
            place++;
        }
        return false;
    }
    public static boolean southeast_checker(int[] move, int color, int[][] board){
        // Checkt of stenen geflipt kunnen worden naar zuidoost.
        int place_x = move[1];
        int place_y = move[0];
        int steps = 0;
        while (place_y != 7 && place_x != 7){
            if (board[place_y+1][place_x+1] == 0){
                return false;
            }
            else if (board[place_y+1][place_x+1] == color) {
                return steps != 0; // make sure we met an enemy stone first
            }
            steps++;
            place_x++;
            place_y++;
        }
        return false;
    }
    public static boolean south_checker(int[]move, int color, int[][] board){
        // Checkt of stenen geflipt kunnen worden naar zuid.
        int place = move[0];
        int steps = 0;
        while(place != 7){
            if(board[place+1][move[1]] == 0){
                return false;
            }
            else if (board[place+1][move[1]] == color) {
                return steps != 0; // make sure we met an enemy stone first
            }
            steps++;
            place++;
        }
        return false;
    }
    public static boolean southwest_checker(int[] move, int color, int[][] board){
        // Checkt of stenen geflipt kunnen worden naar zuidwest.
        int place_x = move[1];
        int place_y = move[0];
        int steps = 0;
        while (place_y != 7 && place_x != 0){
            if (board[place_y+1][place_x-1] == 0){
                return false;
            }
            else if (board[place_y+1][place_x-1] == color) {
                return steps != 0; // make sure we met an enemy stone first
            }
            steps++;
            place_x--;
            place_y++;
        }
        return false;
    }

    public static boolean west_checker(int[]move, int color, int[][] board){
        // Checkt of stenen geflipt kunnen worden naar west.
        int place = move[1];
        int steps = 0;
        while(place != 0){
            if(board[move[0]][place-1] == 0){
                return false;
            }
            else if (board[move[0]][place-1] == color) {
                return steps != 0; // make sure we met an enemy stone first
            }
            steps++;
            place--;
        }
        return false;
    }

    public static boolean northwest_checker(int[] move, int color, int[][] board){
        // Checkt of stenen geflipt kunnen worden naar noordwest.
        int place_x = move[1];
        int place_y = move[0];
        int steps = 0;
        while (place_y != 0 && place_x != 0){
            if (board[place_y-1][place_x-1] == 0){
                return false;
            }
            else if (board[place_y-1][place_x-1] == color) {
                return steps != 0; // make sure we met an enemy stone first
            }
            steps++;
            place_x--;
            place_y--;
        }
        return false;
    }
}
