public class OthelloReferee {
    public static boolean validMove(int[] move){
        // move must be on the board
        if (move[0]<0 || move[0] > 7 || move[1]<0 || move[1] > 7){
            return false;
        }
        // move cant be on a space that already has a stone
        if (OthelloBoard.board[move[0]][move[1]] != 0){
            return false;
        }
        // move has to border a stone
        if (move[0] != 0 && move[1] != 0 && move[0] != 7 && move[1] != 7){
            return OthelloBoard.board[move[0] - 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] - 1] != 0 || OthelloBoard.board[move[0] + 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] + 1] != 0;
        } else{
            if (move[0] == 0 && move[1] == 0){
                return OthelloBoard.board[move[0] + 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] + 1] != 0;
            }
            else if (move[0] == 0 && move[1] == 7){
                return OthelloBoard.board[move[0] + 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] - 1] != 0;
            }
            else if (move[0] == 7 && move[1] == 0){
                return OthelloBoard.board[move[0] - 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] + 1] != 0;
            }
            else if (move[0] == 7 && move[1] == 7){
                return OthelloBoard.board[move[0] - 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] - 1] != 0;
            } else{
                if (move[0] == 0){
                    return OthelloBoard.board[move[0]][move[1] - 1] != 0 || OthelloBoard.board[move[0] + 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] + 1] != 0;
                }
                else if (move[0] == 7){
                    return OthelloBoard.board[move[0] - 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] - 1] != 0 || OthelloBoard.board[move[0]][move[1] + 1] != 0;
                }
                else if (move[1] == 0){
                    return OthelloBoard.board[move[0] - 1][move[1]] != 0 || OthelloBoard.board[move[0] + 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] + 1] != 0;
                }
                else{
                    return OthelloBoard.board[move[0] - 1][move[1]] != 0 || OthelloBoard.board[move[0]][move[1] - 1] != 0 || OthelloBoard.board[move[0] + 1][move[1]] != 0;
                }
            }
        }
        // A way to check if stones are flipped
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
}