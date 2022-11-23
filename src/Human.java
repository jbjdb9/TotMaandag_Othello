public class Human{
    static public void move(){
        System.out.println("What is your move?: ");
        int move = Play.input.nextInt();

        while (!Referee.validMove(move)) {
            System.out.println("Invalid move. Please try again.");
            move = Play.input.nextInt();
        }
        Board.update(move);
    }
}
