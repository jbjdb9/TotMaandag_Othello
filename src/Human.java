public class Human{
    static public int tcMove(){
        int move = -1;
        while (!TcReferee.validMove(move)) {
            System.out.println("What is your move?: ");
            move = Play.input.nextInt();
        }
        return move;
    }
    static public int[] othelloMove(){
        int[] move = {-1,-1};
        while (!OthelloReferee.validMove(move)) {
            System.out.println("What is your move?: ");
            String input = Play.input.next().toUpperCase();
            if (input.length() == 2){
                String letters = "ABCDEFGH";
                if(letters.contains(Character.toString(input.charAt(0)))){
                    int row = 0;
                    switch (input.charAt(0)) {
                        // A -> row is already 0
                        case 'B' -> row = 1;
                        case 'C' -> row = 2;
                        case 'D' -> row = 3;
                        case 'E' -> row = 4;
                        case 'F' -> row = 5;
                        case 'G' -> row = 6;
                        case 'H' -> row = 7;
                    }
                    // convert char to int, and subtract 1 to convert position to index.
                    int column = input.charAt(1) - '1';
                    move[0] = column; // Column is 1-8
                    move[1] = row; // Row is A-H
                }
            }
        }
        return move;
    }
}
