public class OthelloAI {
    public static int move(){
        int move = 1;
        if (Play.remote){
            Remote.aiMoved(move);
        }
        return move;
    }
}
