public class Human{
    static public int move(){
        System.out.println("What is your move?: ");
        int move = Play.input.nextInt();

        if (Play.game == 0){
            while (!TcReferee.validMove(move)) {
                System.out.println("Invalid move. Please try again.");
                move = Play.input.nextInt();
            }
        } else {
            while (!OthelloReferee.validMove(move)) {
                System.out.println("Invalid move. Please try again.");
                move = Play.input.nextInt();
            }
        }
        return move;
    }
}
