public class TcAI {
    public static void move(){
        int move = 1;
        if (Play.remote){
            Remote.aiMoved(move);
        }
        TcBoard.update(move);
    }
}
