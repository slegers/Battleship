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
        player1 = new PlayerBoard(20,100);
        player2 = new PlayerBoard(20,100);
        setLayout(new GridLayout(1,2));
        add(player1);
        add(player2);
        this.setTitle("Zeeslag");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000,500));
        this.setBounds(0,0,100,200);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
