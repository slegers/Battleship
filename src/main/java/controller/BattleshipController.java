package controller;

import com.sun.scenario.Settings;
import view.BattleshipBoard;
import view.PlayerBoard;
import view.SettingsView;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipController {

    public BattleshipController(){
        SettingsView.getSettingsView().setController(this);
        SettingsView.getSettingsView();
    }
    public void createBattleshipBoard(Settings settings){
        new BattleshipBoard(this, settings);
    }

    public void createBattleshipBoard() {

    }
}
