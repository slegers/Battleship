package controller;

import com.sun.scenario.Settings;
import model.settings.SettingsFacade;
import view.BattleshipBoard;
import view.PlayerBoard;
import view.SettingsView;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipController {
    private SettingsFacade facade;
    private BattleshipBoard board;

    public BattleshipController(){
        setSettingsFacade(new SettingsFacade());
        SettingsView.getSettingsView().setController(this);
        SettingsView.getSettingsView();
    }

    public void createBattleshipBoard() {
        board = new BattleshipBoard(this);
    }
    public void setSettingsFacade(SettingsFacade facade){
        this.facade = facade;
    }
    public SettingsFacade getSettingsFacade(){
        return facade;
    }
}
