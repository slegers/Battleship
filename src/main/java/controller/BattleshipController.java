package controller;

import model.BoardFacade;
import model.ShipFacade;
import model.settings.SettingsFacade;
import view.BattleshipBoard;
import view.SettingsView;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipController {
    private SettingsFacade facade;
    private BoardFacade boardFacade = new BoardFacade();
    private BattleshipBoard board;

    public BattleshipController(){
        setSettingsFacade(new SettingsFacade());
        SettingsView.getSettingsView().setController(this);
        SettingsView.getSettingsView();
    }

    public void createBattleshipBoard() {
        board = new BattleshipBoard(this);
    }

    public SettingsFacade getSettingsFacade(){
        return facade;
    }

    public void setSettingsFacade(SettingsFacade facade)
    {
        this.facade = facade;
    }

    public ShipFacade getShipFacade(String id){
        return boardFacade.getShipRepo(id);
    }
}
