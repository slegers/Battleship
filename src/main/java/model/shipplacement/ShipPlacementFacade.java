package model.shipplacement;

import model.type.ShipType;
import view.Field;
import view.PlayerBoard;

/**
 * Created by yanice on 16/12/16.
 */
public final class ShipPlacementFacade {

    private ShipPlacement shipPlacement = new ShipPlacement();

    public void mouseEnter(Field f) {
        shipPlacement.mouseEnter(f);
    }

    public void mouseExit(Field f) {
        shipPlacement.mouseExit(f);
    }
    public void mouseClick(Field f){
        shipPlacement.mouseClick(f);
    }

    public void setDirectionOfPlayerBoard(PlayerBoard player1, int i) {
        shipPlacement.setDirectionOfPlayerBoard(player1,i);
    }
    public void setShipTypeOfPlayerBoard(PlayerBoard player1, ShipType shipType) {
        shipPlacement.setShipTypeOfPlayerBoard(player1,shipType);
    }
}
