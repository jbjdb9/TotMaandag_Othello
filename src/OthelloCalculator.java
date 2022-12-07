public class OthelloCalculator {
    //static int move == OthelloGame.move;
    //OthelloBoard.board[move[0][place+1]];

    public static void OthelloCalculator(int[]move, int color){
        north(move, color);
        east(move, color);
        south(move, color);
        west(move, color);
    }
    public static void north(int[]move, int color){
        int place = move[0];
        while(place != 0){
            if(color == OthelloBoard.board[place-1][move[1]]|| OthelloBoard.board[place-1][move[1]] == 0){
                break;
            }
            else{
                OthelloBoard.board[place-1][move[1]] = color;
                place--;
            }
        }
    }

    public static void east(int[]move, int color){
        int place = move[1];
        while(place != 7){
            if(color == OthelloBoard.board[move[0]][place+1]|| OthelloBoard.board[move[0]][place+1] == 0){
                break;
            }
            else{
                OthelloBoard.board[move[0]][place+1] = color;
                place++;
            }
        }
    }
    public static void south(int[]move, int color){
        int place = move[0];
        while(place != 7){
            if(color == OthelloBoard.board[place+1][move[1]]|| OthelloBoard.board[place+1][move[1]] == 0){
                break;
            }
            else{
                OthelloBoard.board[place+1][move[1]] = color;
                place++;
            }
        }
    }
    public static void west(int[]move, int color){
        int place = move[1];
        while(place != 0){
            if(color == OthelloBoard.board[move[0]][place-1]|| OthelloBoard.board[move[0]][place-1] == 0){
                break;
            }
            else{
                OthelloBoard.board[move[0]][place-1] = color;
                place--;
            }
        }
}}
