package view;

import controller.BattleshipController;
import model.type.ShipType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by yanice on 23/11/16.
 */
public class SettingsView extends JFrame{
    private BattleshipController controller;
    private JLabel speler1,speler2, length,height;
    private static JTextField speler1Text, speler2Text, widthText, heightText;
    private ArrayList<JLabel> shipLabels;
    private ArrayList<JTextField> shipText;
    private static volatile SettingsView settingsView;
    private static boolean done = true;
    private JButton play;
    private SettingsView(){
        this.shipLabels = new ArrayList<>();
        this.shipText = new ArrayList<>();
        init();
    }

    public static synchronized SettingsView getSettingsView(){
        if(done ){
            settingsView = new SettingsView();
            done = false;
        }
        return settingsView;
    }
    public void setController(BattleshipController controller){
        this.controller = controller;
    }
    public BattleshipController getController(){
        return this.controller;
    }

    private void init(){
        createComponents();
        setBounds(0,0,100,200);
        setTitle("Zeeslag - Instellingen");
        setVisible(true);
        pack();
    }

    private void createComponents() {
        setLayout(new GridLayout(5 + ShipType.values().length,2));

        speler1 = new JLabel("Speler 1:");
        add(speler1);
        speler1Text = new JTextField();
        add(speler1Text);
        speler2 = new JLabel("Speler 2:");
        add(speler2);
        speler2Text = new JTextField("Computer");
        speler2Text.setEnabled(false);
        add(speler2Text);

        length = new JLabel("Breedte:");
        add(length);
        widthText = new JTextField(10+"");
        widthText.setEnabled(false);
        add(widthText);
        height = new JLabel("Lengte:");
        add(height);
        heightText = new JTextField(10+"");
        heightText.setEnabled(false);
        add(heightText);
        //maakt voor ieder schip type een label en plaatst de hoeveelheid schepen die er gezet kunnen worden.
        for(ShipType schip : ShipType.values()){
            JLabel label = new JLabel("Aantal " + schip.toString() + ":");
            add(label);
            shipLabels.add(label);
            System.out.print(schip.getSize());
            JTextField text = new JTextField(schip.getMaxShips() +"");
            text.setEnabled(false);
            shipText.add(text);
            add(text);
        }

        play = new JButton("play");
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                getController().createBattleshipBoard();
            }
        });
        add(play);
    }


}
