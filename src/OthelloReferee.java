public class OthelloReferee {
    public static boolean win(int[] board){
        return true;
    }
    public static boolean CheckEndable(){
        //if (RToken == 0 && possibleMove() == false){
        //    win();
        //}
        return true;
    }
    public static boolean tie(){
        return true;
    }
    public static boolean validMove(int move){
        return true;
    }

    public static boolean possibleMove() {
        if (OthelloGame.playerOne[2] == 0 && OthelloGame.playerTwo[2] >= 0){
            OthelloGame.gameWin = true;
        }
        else if (OthelloGame.playerOne[2] == 0 && OthelloGame.playerTwo[2] >= 0){
            OthelloGame.playerOne[2] += 1;
            OthelloGame.playerTwo[2] -= 1;
        }
        else if (OthelloGame.playerTwo[2] == 0 && OthelloGame.playerOne[2] >= 0)
            OthelloGame.playerTwo[2] += 1;
        OthelloGame.playerOne[2] -= 1;


        return true;
    }
}