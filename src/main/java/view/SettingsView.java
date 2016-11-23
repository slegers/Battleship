package view;

import controller.BattleshipController;

import javax.swing.*;

/**
 * Created by yanice on 23/11/16.
 */
public class SettingsView extends JFrame{
    private BattleshipController controller;
    public SettingsView(BattleshipController controller){
        this.controller = controller;
    }
    public BattleshipController getController(){
        return controller;
    }
    public void init(){
        setBounds(0,0,100,200);
        setTitle("Zeeslag - Instellingen");
        setVisible(true);
        pack();
    }
}
