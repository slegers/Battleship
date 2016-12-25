package controller;

import model.BoardFacade;
import model.Ship;
import model.ShipFacade;
import model.ai.AiFacade;
import model.observer.Observer;
import model.settings.SettingsFacade;
import model.shipplacement.ShipPlacementFacade;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import view.BattleshipBoard;
import view.Field;
import view.SettingsView;

import javax.swing.*;
import java.util.TreeMap;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipController implements Observer
{
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
			getShipFacade("player").registerObserver(this);
			getShipFacade("ai").registerObserver(this);
			//getShipFacade("ai").getObservers().add(board);
            board.startGame();
        } else {
            JOptionPane.showMessageDialog(null, "You need to place 5 ships first.");

        }
    }

    @Override
    public void update()
    {

    }

    @Override
    public void update(String target) {
		if (getShipFacade("ai").getAllShips().stream().allMatch(Ship::isShipSunk))
		{
			throw new NotImplementedException();//TODO game is won by player
		}
		if (getShipFacade("player").getAllShips().stream().allMatch(Ship::isShipSunk))
		{
			throw new NotImplementedException();//TODO game is won by ai
		}
	}
}
