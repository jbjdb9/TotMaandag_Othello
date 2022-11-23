import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Connect {




    private static boolean login(PrintWriter out, BufferedReader in) {
        out.println("login " + "itv2ag1"); // inlognaam moet geleik zijn met naam in info.contains bij if statement in handleNotInGame
        String response;
        try {
            response = in.readLine();
        } catch (IOException e) {
            out.println("Login failed: no response");
            return false;
        }
        if (!response.equals("OK") && !response.equals("New Game Server [Version 1.0]")) {
            out.println("Login failed: " + response);
            return false;
        } else {
            out.println("Login successful");
        }
        return true;
    }
}