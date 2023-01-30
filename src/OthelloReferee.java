public class OthelloReferee {
    public static boolean validMove(int[] move, int[][] board){
        // move must be on the board
        if (move[0]<0 || move[0] > 7 || move[1]<0 || move[1] > 7){
            return false;
        }
        // move cant be on a space that already has a stone
        if (board[move[0]][move[1]] != 0){
            return false;
        }
        // move has to border a stone
        if (move[0] != 0 && move[1] != 0 && move[0] != 7 && move[1] != 7){
            if (board[move[0] - 1][move[1]] == 0 && board[move[0]][move[1] - 1] == 0 && board[move[0] + 1][move[1]] == 0 && board[move[0]][move[1] + 1] == 0 && board[move[0]+1][move[1] + 1] == 0 && board[move[0]-1][move[1] + 1] == 0 && board[move[0]+1][move[1]-1] == 0 && board[move[0]-1][move[1]-1] == 0){
                return false;
            }
        } else{
            if (move[0] == 0 && move[1] == 0){
                if (board[move[0] + 1][move[1]] == 0 && board[move[0]][move[1] + 1] == 0 && board[move[0]+1][move[1]+1] == 0){
                    return false;
                }
            }
            else if (move[0] == 0 && move[1] == 7){
                if (board[move[0] + 1][move[1]] == 0 && board[move[0]][move[1] - 1] == 0 && board[move[0]+1][move[1]-1] == 0){
                    return false;
                }
            }
            else if (move[0] == 7 && move[1] == 0){
                if (board[move[0] - 1][move[1]] == 0 && board[move[0]][move[1] + 1] == 0 && board[move[0]-1][move[1]+1] == 0){
                    return false;
                }
            }
            else if (move[0] == 7 && move[1] == 7){
                if (board[move[0] - 1][move[1]] == 0 && board[move[0]][move[1] - 1] == 0 && board[move[0]-1][move[1]-1] == 0){
                    return false;
                }
            } else{
                if (move[0] == 0){
                    if (board[move[0]][move[1] - 1] == 0 && board[move[0] + 1][move[1]] == 0 && board[move[0]][move[1] + 1] == 0 && board[move[0]+1][move[1]+1] == 0 && board[move[0]+1][move[1]-1] == 0){
                        return false;
                    }
                }
                else if (move[0] == 7){
                    if (board[move[0] - 1][move[1]] == 0 && board[move[0]][move[1] - 1] == 0 && board[move[0]][move[1] + 1] == 0 && board[move[0]-1][move[1]+1] == 0 && board[move[0]-1][move[1]-1] == 0){
                        return false;
                    }
                }
                else if (move[1] == 0){
                    if (board[move[0] - 1][move[1]] == 0 && board[move[0] + 1][move[1]] == 0 && board[move[0]][move[1] + 1] == 0 && board[move[0]+1][move[1]+1] == 0 && board[move[0]-1][move[1]+1] == 0){
                        return false;
                    }
                }
                else {
                    if (board[move[0] - 1][move[1]] == 0 && board[move[0]][move[1] - 1] == 0 && board[move[0] + 1][move[1]] == 0 && board[move[0]+1][move[1]-1] == 0 && board[move[0]-1][move[1]-1] == 0){
                        return false;
                    }
                }
            }
        }
        if (OthelloGame.turn == 1) {
            return OthelloCalculator.calculator(move, OthelloGame.playerOne[1], OthelloBoard.board);
        } else {
            return OthelloCalculator.calculator(move, OthelloGame.playerTwo[1], OthelloBoard.board);
        }
    }
    public static int win(){
        // Check for a tie
        if (OthelloGame.playerOne[2] == OthelloGame.playerTwo[2]){
            return 3;
        }
        else if (OthelloGame.playerOne[2] > OthelloGame.playerTwo[2]){
            return 1;
        } else{
            return 2;
        }
    }
    public static boolean possibleMove() {
        // No stones left to place
        if (OthelloGame.playerOne[2] == 0 && OthelloGame.playerTwo[2] == 0){
            return false; // No possible moves left
        }
        // Player two gives player one a stone
        if (OthelloGame.playerOne[2] == 0 && OthelloGame.playerTwo[2] >= 0){
            OthelloGame.playerOne[2] += 1;
            OthelloGame.playerTwo[2] -= 1;
        }
        // Player one gives player two a stone
        else if (OthelloGame.playerTwo[2] == 0 && OthelloGame.playerOne[2] >= 0){
            OthelloGame.playerTwo[2] += 1;
            OthelloGame.playerOne[2] -= 1;
        }
        return true; // return true whether stones have been given to the opponent or not
    }
    public static int scoreboard(int color){
        int score = 0;
        for (int row=0; row<8; row++){
            for (int col=0; col<8;col++){
                    if (OthelloBoard.board[row][col] == color){
                        score++;
                    }
            }
        }
        return score;
    }
}