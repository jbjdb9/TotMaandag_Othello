public class OthelloReferee {
    public static boolean validMove(int[] move, int[][] board, int turn){
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
        if (turn == 1) {
            return OthelloCalculator.calculator(move, OthelloGame.playerOne[1], board);
        } else {
            return OthelloCalculator.calculator(move, OthelloGame.playerTwo[1], board);
        }
    }
    public static void win(){
        int score_black = scoreboard(1);
        int score_white = scoreboard(2);
        // Check for a tie
        if (score_black == score_white){
            System.out.println("It's a tie!");
        }
        else if (score_black > score_white){
            System.out.println("Black Wins!");
        } else{
            System.out.println("White Wins!");
        }
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