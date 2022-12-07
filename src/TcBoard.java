public class TcBoard {
    static char[][] board = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
    public static void clear(){
        board[0][0] = '_';
        board[0][2] = '_';
        board[0][4] = '_';
        board[1][0] = '_';
        board[1][2] = '_';
        board[1][4] = '_';
        board[2][0] = ' ';
        board[2][2] = ' ';
        board[2][4] = ' ';
    }
    public static void print(){
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void update(int move) {
        char character;
        if (TcGame.turn == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        switch (move) {
            case 1 -> board[0][0] = character;
            case 2 -> board[0][2] = character;
            case 3 -> board[0][4] = character;
            case 4 -> board[1][0] = character;
            case 5 -> board[1][2] = character;
            case 6 -> board[1][4] = character;
            case 7 -> board[2][0] = character;
            case 8 -> board[2][2] = character;
            case 9 -> board[2][4] = character;
            default -> {}
        }
    }
}
