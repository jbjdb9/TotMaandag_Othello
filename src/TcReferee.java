public class TcReferee {
    public static boolean win(char[][] Board){
        // Vertical
        if (Board[0][0] == 'X' && Board[1][0] == 'X' && Board[2][0] == 'X') {
            return true;
        }
        if (Board[0][0] == 'O' && Board[1][0] == 'O' && Board[2][0] == 'O') {
            return true;
        }

        if (Board[0][2] == 'X' && Board[1][2] == 'X' && Board[2][2] == 'X') {
            return true;
        }
        if (Board[0][2] == 'O' && Board[1][2] == 'O' && Board[2][2] == 'O') {
            return true;
        }

        if (Board[0][4] == 'X' && Board[1][4] == 'X' && Board[2][4] == 'X') {
            return true;
        }
        if (Board[0][4] == 'O' && Board[1][4] == 'O' && Board[2][4] == 'O') {
            return true;
        }

        // Horizontal
        if (Board[0][0] == 'X' && Board[0][2] == 'X' && Board[0][4] == 'X') {
            return true;
        }
        if (Board[0][0] == 'O' && Board[0][2] == 'O' && Board[0][4] == 'O') {
            return true;
        }
        if (Board[1][0] == 'X' && Board[1][2] == 'X' && Board[1][4] == 'X') {
            return true;
        }
        if (Board[1][0] == 'O' && Board[1][2] == 'O' && Board[1][4] == 'O') {
            return true;
        }
        if (Board[2][0] == 'X' && Board[2][2] == 'X' && Board[2][4] == 'X') {
            return true;
        }
        if (Board[2][0] == 'O' && Board[2][2] == 'O' && Board[2][4] == 'O') {
            return true;
        }

        // Diagonal
        if (Board[0][0] == 'X' && Board[1][2] == 'X' && Board[2][4] == 'X') {
            return true;
        }
        if (Board[0][0] == 'O' && Board[1][2] == 'O' && Board[2][4] == 'O') {
            return true;
        }

        if (Board[2][0] == 'X' && Board[1][2] == 'X' && Board[0][4] == 'X') {
            return true;
        }
        return Board[2][0] == 'O' && Board[1][2] == 'O' && Board[0][4] == 'O';
    }
    public static boolean tie(){
        return TcBoard.board[0][0] != '_' && TcBoard.board[0][2] != '_' && TcBoard.board[0][4] != '_' && TcBoard.board[1][0] != '_' && TcBoard.board[1][2] != '_' && TcBoard.board[1][4] != '_' && TcBoard.board[2][0] != ' ' && TcBoard.board[2][2] != ' ' && TcBoard.board[2][4] != ' ';
    }
    public static boolean validMove(int move){
        return switch (move) {
            case 1 -> TcBoard.board[0][0] == '_';
            case 2 -> TcBoard.board[0][2] == '_';
            case 3 -> TcBoard.board[0][4] == '_';
            case 4 -> TcBoard.board[1][0] == '_';
            case 5 -> TcBoard.board[1][2] == '_';
            case 6 -> TcBoard.board[1][4] == '_';
            case 7 -> TcBoard.board[2][0] == ' ';
            case 8 -> TcBoard.board[2][2] == ' ';
            case 9 -> TcBoard.board[2][4] == ' ';
            default -> false;
        };
    }
}
