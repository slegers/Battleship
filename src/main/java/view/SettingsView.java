package view;

import controller.BattleshipController;
import model.settings.SettingsFacade;
import model.type.ShipType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yanice on 23/11/16.
 * @author yanice
 * @author Kevin
 */
public class SettingsView extends JFrame{
    private BattleshipController controller;
    private JLabel speler1,speler2, length,height;
    private static JTextField speler1Text, speler2Text, widthText, heightText;
    private HashMap<ShipType,Integer> shipTypeJTextFieldHashMap;
    private static volatile SettingsView settingsView;
    private static boolean done = true;
    private  JComboBox legStrategieList,attackStrategieList;

    private JButton play;


    private SettingsView(){
        shipTypeJTextFieldHashMap = new HashMap<>();
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

    public void init(){
        createComponents();
        setBounds(0,0,100,200);
        setTitle("Zeeslag - Instellingen");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        setLayout(new GridLayout(7 + ShipType.values().length,2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);

        speler1 = new JLabel("Speler 1:");
        add(speler1);
        speler1Text = new JTextField(controller.getSettingsFacade().getNamePlayer1());
        add(speler1Text);

        speler2 = new JLabel("Speler 2:");
        add(speler2);
        speler2Text = new JTextField(controller.getSettingsFacade().getNamePlayer2());
        speler2Text.setEnabled(false);
        add(speler2Text);

        length = new JLabel("Breedte:");
        add(length);
        widthText = new JTextField(controller.getSettingsFacade().getWidth() + "");
        widthText.setEnabled(false);
        add(widthText);
        height = new JLabel("Lengte:");
        add(height);
        heightText = new JTextField(controller.getSettingsFacade().getHeight() + "");
        heightText.setEnabled(false);
        add(heightText);

        JLabel legStrategieLabel = new JLabel("leg strategie:");
        String[] legStrategie = {"Simple", "Advanced"};
        legStrategieList = new JComboBox(legStrategie);
        legStrategieList.setSelectedItem(getController().getSettingsFacade().getPlaceStrategy());
        JLabel attackStrategieLabel = new JLabel("aanval strategie:");
        String[] attackStrategie = {"Simple", "Advanced"};
        attackStrategieList = new JComboBox(legStrategie);
        attackStrategieList.setSelectedItem(getController().getSettingsFacade().getAttackStrategy());
        add(legStrategieLabel);
        add(legStrategieList);
        add(attackStrategieLabel);
        add(attackStrategieList);
        //maakt voor ieder schip type een label en plaatst de hoeveelheid schepen die er gezet kunnen worden.
        for(ShipType schip : ShipType.values()){
            JLabel label = new JLabel("Aantal " + schip.toString() + ":");
            add(label);
            JTextField text = new JTextField(schip.getMaxShips() +"");
            text.setEnabled(false);
           shipTypeJTextFieldHashMap.put(schip,Integer.parseInt(text.getText()));
            add(text);
        }

        play = new JButton("play");
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(canStartGame()) {
                    setVisible(false);
                    updateSettings();
                    getController().createBattleshipBoard();
                }
            }

            public boolean canStartGame() {
                if(speler1Text.getText().equals("") || speler1Text.getText().trim().isEmpty()){
                    return false;
                }
                return true;

            }
        });
        add(play);
    }
    public void updateSettings(){
        getController().getSettingsFacade().setLength(Integer.parseInt(widthText.getText()));
        getController().getSettingsFacade().setHeight(Integer.parseInt(heightText.getText()));
        getController().getSettingsFacade().setNamePlayer1(speler1Text.getText());
        getController().getSettingsFacade().setNamePlayer2(speler2Text.getText());
        getController().getSettingsFacade().setNamePlayer2(speler2Text.getText());
        getController().getSettingsFacade().setPlaceStrategy(legStrategieList.getSelectedItem().toString());
        getController().getSettingsFacade().setAttackStrategy(attackStrategieList.getSelectedItem().toString());

        for(ShipType schip : ShipType.values()){
            getController().getSettingsFacade().setAmount(schip,shipTypeJTextFieldHashMap.get(schip));
        }
        getController().getSettingsFacade().savePropertiesFile();
    }

}
