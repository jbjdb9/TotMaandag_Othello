import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connect {

    //static Scanner input = new Scanner(System.in);
    //static boolean gameWin = false;
    //static boolean playAgain = true;
    // static boolean remote = false;
    static boolean inGame = false;
    static boolean gameEnded = false;

    public static boolean connect() throws IOException {
        Socket connection;
        try {
            connection = new Socket("localhost", 7789);
        } catch (IOException e) {
            System.out.println("Something went wrong.");
            //implementeer iets zodat de functie niet doorgaat in dit geval
            return false;
        }
            if (connection != null) {
                PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                System.out.println(login(out, in));

        return true;
    }


    private static boolean login(PrintWriter out, BufferedReader in) {
        out.println("login " + "itv2ag1"); // naam moet gelijk zijn met naam bij if statement in handleNotInGame in Remote
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
