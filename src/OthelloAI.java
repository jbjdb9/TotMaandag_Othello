import java.io.IOException;

public class OthelloAI {
    public static int move() throws IOException {
        int move = 1;
        if (Play.remote){
            Remote.aiMoved(move);
        }
        return move;
    }
}
