package view;

import controller.BattleshipController;

import javax.swing.*;

/**
 * Created by yanice on 23/11/16.
 */
public class SettingsView extends JFrame{
    private BattleshipController controller;
    private JLabel speler1,speler2,width,height;
    private JTextField speler1Text, speler2Text, widthText, heightText;
    public SettingsView(BattleshipController controller){
        this.controller = controller;
    }
    public BattleshipController getController(){
        return controller;
    }
    public void init(){
        createComponents();
        setBounds(0,0,100,200);
        setTitle("Zeeslag - Instellingen");
        setVisible(true);
        pack();
    }

    private void createComponents() {
        speler1 = new JLabel();
        add(speler1);
        speler2 = new JLabel();
        add(speler2);
        width = new JLabel();
        add(width);
        height = new JLabel();
        add(height);

        speler1Text = new JTextField();
        add(speler1Text);
        speler2Text = new JTextField("Computer");
        add(speler2Text);
        widthText = new JTextField();
        add(widthText);
        heightText = new JTextField();
        add(heightText);

    }

}
