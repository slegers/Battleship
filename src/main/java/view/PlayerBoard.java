package view;

import model.type.ShipType;
import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

/**
 * Created by Kevin on 23/11/2016.
 * @author yanice
 * @author Kevin
 */
public class PlayerBoard extends JPanel {

    BattleshipBoard board;

    TreeMap<Integer, Field> fields = new TreeMap<Integer, Field>();

    int shipsize = 5;
    int amountOfShips = 0;
    int richting = 1;
    boolean enabled = true;
    ShipType currentShip;

    public  PlayerBoard(int fieldSize,int amountOfTiles, BattleshipBoard board){
        this.board  = board;
        setSize(new Dimension(400,400));
        setLayout(new GridLayout((int)Math.sqrt(amountOfTiles),(int)Math.sqrt(amountOfTiles)));
        setCurrentShip(ShipType.Aircraftcarrier);
        for(int i = 0; i < amountOfTiles; i++){
            Field field = new Field(fieldSize,Color.gray,i, this);
            field.create();
            getFields().put(i,field);
            add(field);
        }
    }

    public void mouseEnter(Field f) {
        board.getController().getShipPlacementFacade().mouseEnter(f,board.getController().getSettingsFacade().getGameIsStarted());
}
    public void mouseExit(Field f) {
        board.getController().getShipPlacementFacade().mouseExit(f,board.getController().getSettingsFacade().getGameIsStarted());
    }
    public void mouseClick(Field f){
        board.getController().getShipPlacementFacade().mouseClick(f,board.getController().getSettingsFacade().getGameIsStarted());
    }

    public int getShipsize() {
        return shipsize;
    }

    public void setShipsize(int shipsize) {
        this.shipsize = shipsize;
    }

    public int getRichting() {
        return richting;
    }

    public void setRichting(int richting) {
        this.richting = richting;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public TreeMap<Integer, Field> getFields() {
        return fields;
    }

    public void setFields(TreeMap<Integer, Field> fields) {
        this.fields = fields;
    }

    public ShipType getCurrentShip() {
        return currentShip;
    }

    public void setCurrentShip(ShipType currentShip) {
        this.currentShip = currentShip;
    }

    public int getAmountOfShips() { return amountOfShips; }

    public void setAmountOfShips(int amountOfShips) { this.amountOfShips = amountOfShips; }

    public BattleshipBoard getBoard() {
        return board;
    }

    public void setBoard(BattleshipBoard board) {
        this.board = board;
    }


}
