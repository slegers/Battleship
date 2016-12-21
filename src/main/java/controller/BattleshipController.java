package controller;

import model.BoardFacade;
import model.ShipFacade;
import model.ai.AiFacade;
import model.settings.SettingsFacade;
import model.shipplacement.ShipPlacementFacade;
import view.BattleshipBoard;
import view.Field;
import view.SettingsView;

import javax.swing.*;
import java.util.TreeMap;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipController {
    private SettingsFacade facade;
    private BoardFacade boardFacade = new BoardFacade();
    private BattleshipBoard board;
    private AiFacade aiFacade = new AiFacade();
    private  ShipPlacementFacade shipPlacementFacade;

	public BattleshipController()
	{
        facade = new SettingsFacade();
        SettingsView.getSettingsView().setController(this);
        SettingsView.getSettingsView().init();
        shipPlacementFacade  =  new ShipPlacementFacade(this);
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

    public ShipFacade getShipFacade(String id){
        return boardFacade.getShipRepo(id);
    }

    public ShipPlacementFacade getShipPlacementFacade(){
        return shipPlacementFacade;
    }

    public void startGame(int amountOfShips, TreeMap<Integer,Field> fields) {
        if(amountOfShips == getSettingsFacade().getMaxShips()) {
            getSettingsFacade().setGameIsStarted();
            getShipPlacementFacade().clearSea(fields);
            getAiFacade().doAction(this);
            getShipFacade("player").getObservers().add(board);
            //getShipFacade("ai").getObservers().add(board);
            board.startGame();
        } else {
            JOptionPane.showMessageDialog(null, "You need to place 5 ships first.");

        }
    }
}
