package controller;

import com.sun.scenario.Settings;
import controller.ai.AiFacade;
import model.BoardFacade;
import model.ShipFacade;
import model.shipplacement.ShipPlacementFacade;
import model.settings.SettingsFacade;
import sun.plugin2.message.GetAppletMessage;
import view.BattleshipBoard;
import view.Field;
import view.SettingsView;

import java.util.TreeMap;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipController {
    private SettingsFacade facade;
    private BoardFacade boardFacade = new BoardFacade();
    private BattleshipBoard board;
    private AiFacade aiFacade = new AiFacade();
    private  ShipPlacementFacade shipPlacementFacade =  new ShipPlacementFacade();
    ;
    public BattleshipController(){

        setSettingsFacade(new SettingsFacade());
        SettingsView.getSettingsView().setController(this);
        SettingsView.getSettingsView();
    }

    public AiFacade getAiFacade()
    {
        return aiFacade;
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

    public ShipPlacementFacade getShipPlacementFacade(){
        return shipPlacementFacade;
    }

    public void startGame(TreeMap<Integer,Field> fields) {
        getSettingsFacade().setGameIsStarted();
        getShipPlacementFacade().clearSea(fields);
    }
}
