package controller;

import model.BoardFacade;
import model.Ship;
import model.ShipFacade;
import model.ai.AiFacade;
import model.observer.Observer;
import model.settings.SettingsFacade;
import model.shipplacement.ShipPlacementFacade;
import view.BattleshipBoard;
import view.Field;
import view.SettingsView;
import view.ShowWinner;

import javax.swing.*;
import java.awt.*;
import java.util.NoSuchElementException;
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
    private ShipPlacementFacade shipPlacementFacade;

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

    public void removeShipFacade(String id){
        boardFacade.dropShipRepo(id);
    }

    public ShipPlacementFacade getShipPlacementFacade(){
        return shipPlacementFacade;
    }

    public void startGame(int amountOfShips, TreeMap<Integer,Field> fields) {
        if(amountOfShips == getSettingsFacade().getMaxShips()) {
            getSettingsFacade().setGameIsStarted(true);
            getShipPlacementFacade().clearSea(fields);
            getAiFacade().doAction(this);
			getShipFacade("player").registerObserver(this);
			getShipFacade("ai").registerObserver(this);
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
    public void update(String target, Color color) {
		if (getShipFacade("ai").getAllShips().stream().allMatch(Ship::isShipSunk))
		{
            new ShowWinner(getSettingsFacade().getNamePlayer1(),getShipFacade("player").getScore());
            resetGame();
        }
		if (getShipFacade("player").getAllShips().stream().allMatch(Ship::isShipSunk))
		{
            new ShowWinner(getSettingsFacade().getNamePlayer2(),getShipFacade("ai").getScore());
            resetGame();
        }

        try {
            getShipFacade("player").getShip(target).inhabitsTarget(target);
            color = Color.yellow;
            getShipFacade("ai").increaseSucesfullHits();
        }catch (NoSuchElementException e){

        }
        //The fist one is needed
        board.update(target,color);
    }

    private void resetGame() {
        getSettingsFacade().setGameIsStarted(false);
        removeShipFacade("ai");
        removeShipFacade("player");
        board.dispose();
        SettingsView.getSettingsView().setVisible(true);
    }
}
