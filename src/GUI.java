import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame Gameframe;

    private JFrame Gamemode;

    private JFrame TTTGame;

    private JLabel cgame;

    private JButton S_TTT;

    private JButton S_Othello;

    private JLabel S_Mode;

    private JButton L_H_VS_H;

    private JButton L_H_VS_AI;

    private JButton L_AI_VS_AI;

    private JButton Remote_AI;


    public GUI() {
        cgame = new JLabel("Welke game wil je spelen?");
        cgame.setBounds(175, 200, 300, 50);
        cgame.setFont(new Font("Arial", Font.PLAIN, 20));

        S_Mode = new JLabel("Selecteer speelmodus");
        S_Mode.setBounds(200, 200, 300, 50);
        S_Mode.setFont(new Font("Arial", Font.PLAIN, 20));

        L_H_VS_H = new JButton("Local Human Vs Human");
        L_H_VS_H.setBounds(150, 250, 150, 50);
        L_H_VS_H.setFont(new Font("Arial", Font.PLAIN, 10));
        L_H_VS_H.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gamemode.setVisible(false);
                if(Play.game == 0){
                        System.out.println("yay");
                }else {
                    new OthelloGui_PVP();
                }
            }
        });

        L_H_VS_AI = new JButton("Local Human Vs AI");
        L_H_VS_AI.setBounds(300, 250, 150, 50);
        L_H_VS_AI.setFont(new Font("Arial", Font.PLAIN, 10));
        L_H_VS_AI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gamemode.setVisible(false);
                if(Play.game == 0){
                    System.out.println("yay3");
                }else {
                    System.out.println("yay4");
                }
            }
        });

        L_AI_VS_AI = new JButton("Local AI Vs AI");
        L_AI_VS_AI.setBounds(150, 300, 150, 50);
        L_AI_VS_AI.setFont(new Font("Arial", Font.PLAIN, 10));
        L_AI_VS_AI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gamemode.setVisible(false);
                if(Play.game == 0){
                    System.out.println("yay5");
                }else {
                    System.out.println("yay6");
                }
            }
        });

        Remote_AI = new JButton("Remote AI");
        Remote_AI.setBounds(300, 300, 150, 50);
        Remote_AI.setFont(new Font("Arial", Font.PLAIN, 10));
        Remote_AI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gamemode.setVisible(false);
                if(Play.game == 0){
                    System.out.println("yay7");
                }else {
                    System.out.println("yay8");
                }
            }
        });

        S_TTT = new JButton("Tic-Tac-Toe");
        S_TTT.setBounds(150, 250, 150, 50);
        S_TTT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Play.game = 0;
                Gameframe.setVisible(false);
                Gamemode.setVisible(true);
            }
        });


        S_Othello = new JButton("Othello");
        S_Othello.setBounds(300, 250, 150, 50);
        S_Othello.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Play.game = 1;
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
        Gamemode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gamemode.setTitle("Selecteer modus");

        Gamemode.add(S_Mode);
        Gamemode.add(L_H_VS_H);
        Gamemode.add(L_H_VS_AI);
        Gamemode.add(L_AI_VS_AI);
        Gamemode.add(Remote_AI);

        TTTGame = new JFrame();
        TTTGame.setSize(1200, 800);
        TTTGame.setLayout(null);
        TTTGame.setVisible(false);
        TTTGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TTTGame.setTitle("Tic-Tac-Toe");



    }

    public static void main(String[] args) {
        System.out.println(new GUI());
    }
}

