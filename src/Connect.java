import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect {
    public static Socket connection;
    public static String username = "TotMaandag1";
    public static boolean connected = false;
    public static boolean connect() throws IOException {
        try {
            connection = new Socket("localhost", 7789);
        } catch (IOException e) {
            System.out.println("Something went wrong.");
            return false;
        }
        PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return login(out, in);
    }
        private static boolean login (PrintWriter out, BufferedReader in){
            out.println("login " + username);
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
            connected = true;
            return true;

        }
    }
