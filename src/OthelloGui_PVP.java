import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OthelloGui_PVP implements ActionListener {
    private JFrame OthelloGame;
    static Button[][] button_list = new Button[8][8];
    static int turn = 2;

    private char black = '⚫';

    private char white = '⚪';

    static int[] move;
    private static JLabel score_w = new JLabel();
    private static JLabel score_b = new JLabel();

    private JLabel gamewon = new JLabel();

    @Override
    public void actionPerformed (ActionEvent e){
        String action_button = e.getActionCommand();
        System.out.println(action_button);
        int[] position = OthelloAI.PositionTranslate_str_inta(action_button);
        OthelloBoard.update(position, OthelloBoard.board, turn);
        Othelloboardclear();
        try {
            Othelloboardmaker();
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        try {
            Othelloboardupdater();
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }


    public OthelloGui_PVP() throws IOException, InterruptedException {
        OthelloGame = new JFrame();
        OthelloGame.setSize(1200, 835);
        OthelloGame.setLayout(null);
        OthelloGame.setVisible(true);
        OthelloGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OthelloGame.setTitle("Othello");
        Othelloboardmaker();
    }

    public void Othelloboardmaker() throws IOException, InterruptedException {
        if (OthelloBoard.getPossibleMoves(OthelloBoard.board, 2).length ==0 && OthelloBoard.getPossibleMoves(OthelloBoard.board, 1).length == 0) {
            gamewon.setVisible(true);
            System.out.println("Einde spel");
            score_b.setText(win());
            score_w.setText("self destruct in 5 seconds");
            Thread.sleep(5000);
            System.exit(0);
            return;
        }
        if (OthelloBoard.getPossibleMoves(OthelloBoard.board, turn).length == 0){
            turn = OthelloAI.turnSwitch(turn);
        }
        int loc_per_button_x = 0;
        int loc_per_button_y = 0;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int[] pos = {row, col};

                String button_name = OthelloAI.PositionTranslate_inta_str(pos);
                Button button = new Button(button_name);
                button_list[row][col] = button;
                button.setBounds(loc_per_button_x, loc_per_button_y, 100, 100);
                if (OthelloBoard.board[row][col]==1){
                    button.setBackground(Color.BLACK);
                }
                if (OthelloBoard.board[row][col]==2){
                    button.setBackground(Color.WHITE);

                }
                if (OthelloBoard.board[row][col]==0){
                    Color allbuttons =new Color(0, 89, 6);
                    button.setBackground(allbuttons);

                }
                if (OthelloReferee.validMove(pos, OthelloBoard.board, turn)) {
                    Color validmovecolor =new Color(0, 166, 11);
                    button.setBackground(validmovecolor);
                    button.addActionListener(this);
                }

                OthelloGame.add(button);
                loc_per_button_x += 100;
            }
            loc_per_button_y += 100;
            loc_per_button_x = 0;
        }
        score_b.setText("- Black: " + OthelloReferee.scoreboard(1));
        score_b.setBounds(825, 50, 300, 100);
        score_b.setFont(new Font("Arial", Font.PLAIN, 50));
        OthelloGame.add(score_b);
        score_w.setText("- White: " + OthelloReferee.scoreboard(2));
        score_w.setBounds(825, 150, 300, 100);
        score_w.setFont(new Font("Arial", Font.PLAIN, 50));
        OthelloGame.add(score_w);
        gamewon.setText("selfdestruct in 5");
        gamewon.setBounds(825, 350, 300, 100);
        gamewon.setVisible(false);
        OthelloGame.add(gamewon);
        if (GUI.GM_selected == 3) {
            Othelloboardupdater();
        }

    }
    public void Othelloboardclear(){
        for (Button[] button_row: button_list){
            for (Button button_col: button_row){
                OthelloGame.remove(button_col);
            }
        }
    }
    public void Othelloboardupdater() throws IOException, InterruptedException {
        turn = OthelloAI.turnSwitch(turn);
        // clear the current board
        if (GUI.GM_selected == 1){
            Othelloboardclear();
        }
        if ((GUI.GM_selected == 2)){
            int[] move = OthelloAI.move();
            System.out.println(OthelloAI.PositionTranslate_inta_str(move));
            OthelloBoard.update(move, OthelloBoard.board, turn);
            turn = OthelloAI.turnSwitch(turn);
            Othelloboardclear();

        }
        if ((GUI.GM_selected == 3)){
            boolean game = true;
            while (game == true){
                if (OthelloBoard.getPossibleMoves(OthelloBoard.board, 2).length ==0 && OthelloBoard.getPossibleMoves(OthelloBoard.board, 1).length == 0) {
                    game = false;
                }
                int[] move = OthelloAI.move();
                System.out.println(OthelloAI.PositionTranslate_inta_str(move));
                OthelloBoard.update(move, OthelloBoard.board, turn);
                Othelloboardclear();
                Othelloboardmaker();
                Thread.sleep(500);
                turn = OthelloAI.turnSwitch(turn);
            }
        }
        if ((GUI.GM_selected == 4)){

        }

        // Makes the new board
        Othelloboardmaker();
    }
    public static String win(){
        int score_black = OthelloReferee.scoreboard(1);
        int score_white = OthelloReferee.scoreboard(2);
        // Check for a tie
        if (score_black == score_white){
            return "I'ts a tie!!";
        }
        else if (score_black > score_white){
            return "Black Wins!";
        } else{
            return "White Wins!";
        }
    }
}

