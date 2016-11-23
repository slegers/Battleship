package view;

import controller.BattleshipController;

import javax.swing.*;

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
        this.setBounds(0,0,100,200);
        this.pack();
        this.setVisible(true);
    }
}
