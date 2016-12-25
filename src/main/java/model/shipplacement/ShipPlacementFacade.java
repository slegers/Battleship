package model.shipplacement;

import controller.BattleshipController;
import model.Ship;
import model.Target;
import model.type.ShipType;
import view.Field;
import view.PlayerBoard;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by yanice on 16/12/16.
 * @author Yanice Slegers
 */
public final class ShipPlacementFacade {

    private ShipPlacement shipPlacement;
    public ShipPlacementFacade(BattleshipController controller){
        shipPlacement = new ShipPlacement(controller);    }
    public void mouseEnter(Field f,boolean gameStarted) {
        shipPlacement.mouseEnter(f,gameStarted);
    }

    public void mouseExit(Field f, boolean gameStarted) {
        shipPlacement.mouseExit(f,gameStarted);
    }
    public void mouseClick(Field f, boolean gameStarted){
        shipPlacement.mouseClick(f,gameStarted);
    }

    public void setRedOnSunk(Target target, Field f){shipPlacement.setRedOnSunk(target,f);};

    public void setDirectionOfPlayerBoard(PlayerBoard player1, int i) {
        shipPlacement.setDirectionOfPlayerBoard(player1,i);
    }
    public void setShipTypeOfPlayerBoard(PlayerBoard player1, ShipType shipType) {
        shipPlacement.setShipTypeOfPlayerBoard(player1,shipType);
    }
    public void clearSea(TreeMap<Integer,Field> fields){
        shipPlacement.clearSea(fields);
    }

}
