public class OthelloChecker {

    public static boolean north_checker(int[]move, int color){
        int place = move[0];
        while(place != 0){
            if(OthelloBoard.board[place-1][move[1]] == 0){
                return false;
            }
            else if (OthelloBoard.board[place-1][move[1]] == color) {
                return true;
            }
            place--;
        }
        return false;
    }

    public static boolean east_checker(int[]move, int color){
        int place = move[1];
        while(place != 7){
            if(OthelloBoard.board[move[0]][place+1] == 0){
                return false;
            }
            else if (OthelloBoard.board[move[0]][place+1] == color) {
                return true;
            }
            place++;
        }
        return false;
    }

    public static boolean south_checker(int[]move, int color){
        int place = move[0];
        while(place != 7){
            if(OthelloBoard.board[place+1][move[1]] == 0){
                return false;
            }
            else if (OthelloBoard.board[place+1][move[1]] == color) {
                return true;
            }
            place++;
        }
        return false;
    }
    public static boolean west_checker(int[]move, int color){
        int place = move[1];
        while(place != 0){
            if(OthelloBoard.board[move[0]][place-1] == 0){
                return false;
            }
            else if (OthelloBoard.board[move[0]][place-1] == color) {
                return true;
            }
            place--;
        }
        return false;
    }
}
