public class AI{
    public static void move(){
        int move = 1;
        if (Play.remote){
            Remote.aiMoved(move);
        }
        Board.update(move);
    }
}
