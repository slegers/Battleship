package controller;

import model.BoardFacade;
import model.Ship;
import model.ShipFacade;
import model.Target;
import model.ai.AiFacade;
import model.observer.Observer;
import model.settings.SettingsFacade;
import model.shipplacement.ShipPlacement;
import model.shipplacement.ShipPlacementFacade;
import view.BattleshipBoard;
import view.Field;
import view.SettingsView;
import view.ShowWinner;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    public void update(String targetString, Color color) {
        try {
            getShipFacade("player").getShip(targetString).inhabitsTarget(targetString);
            color = Color.yellow;
            getShipFacade("ai").increaseSucesfullHits();
            System.out.println(targetString);
            java.util.List<Ship> enemyShips = getShipFacade("player").getAllShips();
            HashMap<Integer, Target> targets = new HashMap<Integer, Target>();
            for (Ship s : enemyShips) {
                for (Target t : s.getTargets()) {
                    targets.put(Integer.parseInt(t.getName()), t);
                }
            }
            Target target = targets.get(Integer.parseInt(targetString));
            System.out.println();
            target.getName();
            getShipPlacementFacade().setRedOnSunk(target, board.player1.getFields().get(Integer.parseInt(targetString)));
        } catch (NoSuchElementException e) {

        }

        if (getShipFacade("ai").getAllShips().stream().allMatch(Ship::isShipSunk)) {
            new ShowWinner(getSettingsFacade().getNamePlayer1(), 10);
            resetGame();
        }
        if (getShipFacade("player").getAllShips().stream().allMatch(Ship::isShipSunk)) {
            new ShowWinner(getSettingsFacade().getNamePlayer2(), 10);
            resetGame();
        }


        board.update(targetString, color);
    }

    private void resetGame() {
        getSettingsFacade().setGameIsStarted(false);
        removeShipFacade("ai");
        removeShipFacade("player");
        board.dispose();
        SettingsView.getSettingsView().setVisible(true);
    }
}
