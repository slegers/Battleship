package controller;

import view.BattleshipBoard;
import view.SettingsView;

/**
 * Created by yanice on 18/11/16.
 */
public class Main {
    public static void main(String[] args) {
        BattleshipController controller = new BattleshipController();
        SettingsView settingsView = new SettingsView(controller);
        settingsView.init();
        BattleshipBoard view = new BattleshipBoard(controller);
    }
}
