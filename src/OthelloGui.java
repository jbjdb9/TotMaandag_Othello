import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OthelloGui implements ActionListener {
    private JFrame OthelloGame;
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void Othelloboardmaker() {
        OthelloGame = new JFrame();
        OthelloGame.setSize(1200, 835);
        OthelloGame.setLayout(null);
        OthelloGame.setVisible(false);
        OthelloGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OthelloGame.setTitle("Othello");

        int turn = 2;
        int loc_per_button_x = 0;
        int loc_per_button_y = 0;
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                int[] pos = {row, col};
                String B_name = OthelloAI.PositionTranslate(pos);
                Button test_b = new Button(B_name);
                test_b.setBounds(loc_per_button_x, loc_per_button_y, 100 ,100);
                if (OthelloReferee.validMove(pos, OthelloBoard.board, turn)){
                    test_b.addActionListener(this);
                }
                OthelloGame.add(test_b);
                loc_per_button_x += 100;
            }
            loc_per_button_y += 100;
            loc_per_button_x = 0;
        }
    }
}


