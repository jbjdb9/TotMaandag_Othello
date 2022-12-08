public class OthelloBoard {
    static int[][] board =
            {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 2, 0, 0, 0},
                    {0, 0, 0, 2, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
    public static void clear(){
        board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 2, 0, 0, 0},
                {0, 0, 0, 2, 1, 0, 0, 0},
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
            int column = 0;
            System.out.print(row+1 + "|");
            for(;column < 8;column++){
                if(board[row][column] != 0){
                    if(board[row][column] == 1){
                        System.out.print("⚫|");
                    } else{
                        System.out.print("⚪|");
                    }
                } else{
                    System.out.print("\uD83D\uDFE9|");
                }
            }
        }
        // Code for an over line
        System.out.println("\n ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }
    public static void update(int[] move) {
        if (OthelloGame.turn == 1) {
            board[move[0]][move[1]] = OthelloGame.playerOne[1];
            OthelloCalculator.othelloCalculator(move, OthelloGame.playerOne[1]);
        } else {
            board[move[0]][move[1]] = OthelloGame.playerTwo[1];
            OthelloCalculator.othelloCalculator(move, OthelloGame.playerTwo[1]);
        }
    }
}
