package view;

import controller.BattleshipController;
import model.Ship;
import model.type.ShipType;

import javax.swing.*;
import java.awt.*;

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

    public SettingsView() {

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
        setLayout(new GridLayout(4,2));

        speler1 = new JLabel("Speler 1:");
        add(speler1);
        speler1Text = new JTextField();
        add(speler1Text);
        speler2 = new JLabel("Speler 2:");
        add(speler2);
        speler2Text = new JTextField("Computer");
        add(speler2Text);

        width = new JLabel("Breedte:");
        add(width);
        widthText = new JTextField();
        add(widthText);
        height = new JLabel("Lengte:");
        add(height);
        heightText = new JTextField();
        add(heightText);

        /*foreach(Ship schip : ShipType.values()){

        }
        */
    }

}
