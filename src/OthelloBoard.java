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
        System.out.print("  \u0332A \u0332B \u0332C \u0332D \u0332E \u0332F \u0332G \u0332H");
        // Print the board
        for(int row = 0;row < 8;row++){
            System.out.println("");
            int column = 0;
            System.out.print(row+1 + "|");
            for(;column < 8;column++){
                if(board[row][column] != 0){
                    if(board[row][column] == 1){
                        System.out.print("●|");
                    } else{
                        System.out.print("○|");
                    }
                } else{
                    System.out.print(" |");
                }
            }
        }
        // Code for an over line
        System.out.println("\n ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }
    public static void update(int[] move){
        if(OthelloGame.turn == 1){
            board[move[0]][move[1]] = OthelloGame.playerOne[1];
            // call flip()
        } else {
            board[move[0]][move[1]] = OthelloGame.playerTwo[1];
            // call flip()
        }
    }
    public static boolean flip(int[] move){
        return true; // true if stones where flipped, false if no stones where flipped. This only matters for OthelloReferee.validMove()
    }
}
