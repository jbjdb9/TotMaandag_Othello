import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OthelloGui_PVE implements ActionListener {
    private JFrame OthelloGame;
    static Button[][] button_list = new Button[8][8];
    static int turn = 2;

    static int[] move;
    private static JLabel score_w = new JLabel();
    private static JLabel score_b = new JLabel();
    @Override
    public void actionPerformed (ActionEvent e){
        String action_button = e.getActionCommand();
        System.out.println(action_button);
        int[] position = OthelloAI.PositionTranslate_str_inta(action_button);
        OthelloBoard.update(position, OthelloBoard.board, turn);
        Othelloboardupdater();
    }


    public OthelloGui_PVE() {
        OthelloGame = new JFrame();
        OthelloGame.setSize(1200, 835);
        OthelloGame.setLayout(null);
        OthelloGame.setVisible(true);
        OthelloGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OthelloGame.setTitle("Othello");
        Othelloboardmaker();
    }

    public void Othelloboardmaker(){
        if (OthelloBoard.getPossibleMoves(OthelloBoard.board, 2).length ==0 && OthelloBoard.getPossibleMoves(OthelloBoard.board, 1).length == 0) {
            System.out.println("Einde spel");
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
        score_b.setText("- ⚫Black: " + OthelloReferee.scoreboard(1));
        score_b.setBounds(825, 50, 300, 100);
        score_b.setFont(new Font("Arial", Font.PLAIN, 50));
        OthelloGame.add(score_b);
        score_w.setText("- ⚪White: " + OthelloReferee.scoreboard(2));
        score_w.setBounds(825, 150, 300, 100);
        score_w.setFont(new Font("Arial", Font.PLAIN, 50));
        OthelloGame.add(score_w);

    }

    public void Othelloboardupdater(){
        turn = OthelloAI.turnSwitch(turn);
        // clear the current board
        for (Button[] button_row: button_list){
            for (Button button_col: button_row){
                OthelloGame.remove(button_col);
            }
        }
        // Makes the new board
        Othelloboardmaker();
    }
}
