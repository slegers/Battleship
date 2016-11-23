package view;

import controller.BattleshipController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipBoard extends JFrame{
    private BattleshipController controller;
    public BattleshipBoard(BattleshipController controller) {
        this.controller = controller;
        createBoard();
    }
    public BattleshipController getController(){
        return controller;
    }

    public void createBoard(){
        this.setTitle("Zeeslag");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000,500));
        this.setBounds(0,0,100,200);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
