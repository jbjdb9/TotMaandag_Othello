import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class OthelloGui implements ActionListener {
    private JFrame OthelloGame;
    static Button[][] button_list = new Button[8][8];
    static int turn = 2;

    static int[] move;
    //static JLabel score = new JLabel();
    @Override
    public void actionPerformed (ActionEvent e){
        String action_button = e.getActionCommand();
        System.out.println(action_button);
        int[] position = OthelloAI.PositionTranslate_str_inta(action_button);
        OthelloBoard.update(position, OthelloBoard.board, turn);
        Othelloboardupdater();

    }
    public OthelloGui() {
        OthelloGame = new JFrame();
        OthelloGame.setSize(1200, 835);
        OthelloGame.setLayout(null);
        OthelloGame.setVisible(true);
        OthelloGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OthelloGame.setTitle("Othello");
        Othelloboardmaker();
    }

    public void Othelloboardmaker(){
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
                    //button.setLabel("⚫");
                }
                if (OthelloBoard.board[row][col]==2){
                    button.setBackground(Color.WHITE);
                    //button.setLabel("⚪");

                }
                if (OthelloBoard.board[row][col]==0){
                    button.setBackground(Color.GREEN);
                    //button.setLabel("\uD83D\uDFE9");

                }
                if (OthelloReferee.validMove(pos, OthelloBoard.board, turn)) {
                    button.setBackground(Color.RED);
                    //button.setLabel("❎");
                    button.addActionListener(this);
                }

                OthelloGame.add(button);
                loc_per_button_x += 100;
            }
            loc_per_button_y += 100;
            loc_per_button_x = 0;
        }

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

    public static void main(String[] args) {
        new OthelloGui();
    }
}

