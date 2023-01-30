public class OthelloBoard {
    static int[][] board =
            {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 2, 1, 0, 0, 0},
                    {0, 0, 0, 1, 2, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
    public static void clear(){
        board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 1, 0, 0, 0},
                {0, 0, 0, 1, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
    }
    public static void print(){
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
                    if (OthelloReferee.validMove(new int[]{row, column}, OthelloBoard.board)){
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
    public static void update(int[] move, int[][] board, int turn) {
        if (turn == 1) {
            board[move[0]][move[1]] = OthelloGame.playerOne[1];
            OthelloCalculator.flipper(move, OthelloGame.playerOne[1], board);
        } else {
            board[move[0]][move[1]] = OthelloGame.playerTwo[1];
            OthelloCalculator.flipper(move, OthelloGame.playerTwo[1], board);
        }
    }
}
