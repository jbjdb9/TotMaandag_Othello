import java.util.Random;

public class TcAI {
    public static int move(){
        int move = 0;
        if (AiWin(TcBoard.board, 'O') != 0) {
            move = AiWin(TcBoard.board, 'O');
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (AiWin(TcBoard.board, 'X') != 0) {
            move = AiWin(TcBoard.board, 'X');
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            while (!TcReferee.validMove(move)) {
                move = AiMovesOptions();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("AI chose: " + move);
        if (Play.remote){
            Remote.aiMoved(move);
        }
        return move;
    }
    public static int AiWin(char[][] Board, char character) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (Board[x][y * 2] == '_' || Board[x][y * 2] == ' ') {
                    Board[x][y * 2] = character;
                    if (TcReferee.win(Board)) {
                        if (x != 2) {
                            Board[x][y * 2] = '_';
                        } else {
                            Board[x][y * 2] = ' ';
                        }
                        return BoardToInt(x, y);
                    } else {
                        if (x != 2) {
                            Board[x][y * 2] = '_';
                        } else {
                            Board[x][y * 2] = ' ';
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static int AiMovesOptions() {
        if (TcBoard.board[0][0] == '_') {
            return 1;
        } else if (TcBoard.board[0][4] == '_') {
            return 3;
        } else if (TcBoard.board[2][0] == ' ') {
            return 7;
        } else if (TcBoard.board[2][4] == ' ') {
            return 9;
        } else if (TcBoard.board[1][2] == '_') {
            return 5;
        }
        Random rng = new Random();
        return rng.nextInt(9) + 1;
    }


    public static int BoardToInt(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x == 0 && y == 1) {
            return 2;
        }
        if (x == 0 && y == 2) {
            return 3;
        }
        if (x == 1 && y == 0) {
            return 4;
        }
        if (x == 1 && y == 1) {
            return 5;
        }
        if (x == 1 && y == 2) {
            return 6;
        }
        if (x == 2 && y == 0) {
            return 7;
        }
        if (x == 2 && y == 1) {
            return 8;
        }
        if (x == 2 && y == 2) {
            return 9;
        } else {
            return 0;
        }
    }
}
