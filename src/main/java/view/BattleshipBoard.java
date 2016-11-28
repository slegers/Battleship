package view;

import controller.BattleshipController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipBoard extends JFrame{
    private BattleshipController controller;
    private PlayerBoard player1;
    private PlayerBoard player2;

    public BattleshipBoard(BattleshipController controller) {
        this.controller = controller;
        createBoard();
    }

    public BattleshipController getController(){
        return controller;
    }

    public void createBoard(){
        JPanel player1Panel = new JPanel();
        player1Panel.setLayout(new FlowLayout());
        JLabel player1Label = new JLabel("player1");
        player1 = new PlayerBoard(30,100);
        player1Panel.add(player1Label);
        player1Panel.add(player1);

        JPanel player2Panel = new JPanel();
        player2Panel.setLayout(new FlowLayout());
        JLabel player2Label = new JLabel("player2");
        player2 = new PlayerBoard(30,100);
        player2Panel.add(player2Label);
        player2Panel.add(player2);

        setLayout(new GridLayout(1,2));
        add(player1Panel);
        add(player2Panel);

        this.setTitle("Zeeslag");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(700,380));
        //this.setBounds(0,0,100,200);
        //this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
