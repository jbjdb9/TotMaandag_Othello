public class OthelloCalculator {
    //static int move == OthelloGame.move;
    //OthelloBoard.board[move[0][place+1]];

    public static void OthelloCalculator(int[]move, int color){
        east(move, color);
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
}
