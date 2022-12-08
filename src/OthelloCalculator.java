public class OthelloCalculator {
    //static int move == OthelloGame.move;
    //OthelloBoard.board[move[0][place+1]];

    public static void othelloCalculator(int[]move, int color){
        north(move, color);
        northeast(move, color);
        east(move, color);
        southeast(move, color);
        south(move, color);
        southwest(move, color);
        west(move, color);
        northwest(move, color);
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
    public static void northeast(int[]move, int color){
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 0 && place_x != 7){
            if(color == OthelloBoard.board[place_y-1][place_x+1]|| OthelloBoard.board[place_y-1][place_x+1] == 0){
                break;
            }
            else{
                OthelloBoard.board[place_y-1][place_x+1] = color;
                place_y--;
                place_x++;
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
    public static void southeast(int[]move, int color){
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 7 && place_x != 7){
            if(color == OthelloBoard.board[place_y+1][place_x+1]|| OthelloBoard.board[place_y+1][place_x+1] == 0){
                break;
            }
            else{
                OthelloBoard.board[place_y+1][place_x+1] = color;
                place_y++;
                place_x++;
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
    public static void southwest(int[]move, int color){
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 7 && place_x != 0){
            if(color == OthelloBoard.board[place_y+1][place_x-1]|| OthelloBoard.board[place_y+1][place_x-1] == 0){
                break;
            }
            else{
                OthelloBoard.board[place_y+1][place_x-1] = color;
                place_y++;
                place_x--;
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
    }
    public static void northwest(int[]move, int color){
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 0 && place_x != 0){
            if(color == OthelloBoard.board[place_y-1][place_x-1]|| OthelloBoard.board[place_y-1][place_x-1] == 0){
                break;
            }
            else{
                OthelloBoard.board[place_y-1][place_x-1] = color;
                place_y--;
                place_x--;
            }
        }
    }
}

