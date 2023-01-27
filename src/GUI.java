import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GUI {
    private JFrame Gameframe;

    private JFrame Gamemode;

    private JLabel cgame;

    private JButton S_TTT;

    private JButton S_Othello;


    public GUI() {
        cgame = new JLabel("Welke game wil je spelen?");
        cgame.setBounds(175, 200, 300, 50);
        cgame.setFont(new Font("Arial", Font.PLAIN, 20));

        S_TTT = new JButton("Tic-Tac-Toe");
        S_TTT.setBounds(150, 250, 150, 50);
        S_TTT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gameframe.setVisible(false);
                Gamemode.setVisible(true);
            }
        });


        S_Othello = new JButton("Othello");
        S_Othello.setBounds(300, 250, 150, 50);
        S_Othello.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gameframe.setVisible(false);
                Gamemode.setVisible(true);

            }
        });
        Gameframe = new JFrame();
        Gameframe.setSize(600, 600);
        Gameframe.setLayout(null);

        Gameframe.add(cgame);
        Gameframe.add(S_TTT);
        Gameframe.add(S_Othello);
        Gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gameframe.setVisible(true);
        Gameframe.setTitle("Kies een spel");

        Gamemode = new JFrame();
        Gamemode.setSize(600, 600);
        Gamemode.setLayout(null);
        Gamemode.setVisible(false);
    }
    public static void main(String[] args) {
        System.out.println(new GUI());
    }
}

