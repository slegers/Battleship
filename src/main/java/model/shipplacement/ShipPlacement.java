package model.shipplacement;

import controller.BattleshipController;
import model.Ship;
import model.ShipFacade;
import model.Target;
import model.TargetFactory;
import model.factory.ShipFactory;
import model.targetState.TargetStateFactory;
import model.type.ShipType;
import view.Field;
import view.PlayerBoard;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Yanice on 15/12/2016.
 * @author Yanice Slegers
 */
public class ShipPlacement {

    private BattleshipController controller;

    public ShipPlacement(BattleshipController controller){
        this.controller = controller;
    }

    public void setDirectionOfPlayerBoard(PlayerBoard board, int direction) {
        board.setRichting(direction);
    }

    public void setShipTypeOfPlayerBoard(PlayerBoard board, ShipType type) {
        board.setCurrentShip(type);
        board.setShipsize(type.getSize());
    }

    public void mouseEnter(Field f, boolean started) {
        int column = f.getNumber() % 10;
        int row = f.getNumber() / 10;
        if(!started){
            if (f.getBackground().equals(getStandardBackGroundColor()) && f.getPlayerBoard().isEnabled() && canDrawShip(column, row, f.getNumber(), f)) {
                drawShip(f, getHoverBackGroundColor(), getHoverBackGroundColor());
            }
        }
    }

    public void mouseExit(Field f,boolean started) {
        if(!started){
        if (f.getPlayerBoard().isEnabled() && f.getBackground().equals(getHoverBackGroundColor()) && f.getPlayerBoard().isEnabled()) {
            int column = f.getNumber() % 10;
            int row = f.getNumber() / 10;
            if (canDrawShip(column, row, f.getNumber(), f)) {
                unDrawShip(f);
            }
        }
        }
    }

    public void mouseClick(Field f, boolean started) {
        if(!started) {
            if (f.getPlayerBoard().getCurrentShip().getMaxShips() <= 0) {
                JOptionPane.showMessageDialog(null, "You already have too much ships of this type.");
            } else if (f.getPlayerBoard().getAmountOfShips() >= 5) {
                JOptionPane.showMessageDialog(null, "You have placed 5 ships already, press 'Start' to start the game.");
            } else {
                int column = f.getNumber() % 10;
                int row = f.getNumber() / 10;
                if (f.getPlayerBoard().isEnabled() && canDrawShip(column, row, f.getNumber(), f)) {
                    drawNeighbours(f);
                    drawShip(f, getSelectedBackgroundColor(), getStandardBorderColor());
                    f.getPlayerBoard().getCurrentShip().setMaxShips(f.getPlayerBoard().getCurrentShip().getMaxShips() - 1);
                    f.getPlayerBoard().setAmountOfShips(f.getPlayerBoard().getAmountOfShips() + 1);
                    ArrayList<Target> shipTargets = new ArrayList<Target>();
                    for(int i = 0; i < f.getPlayerBoard().getShipsize(); i++){
                        int offset = 0;
                        if(f.getPlayerBoard().getRichting() == 1){
                            offset = f.getNumber() + i;
                        }else{
                            offset = f.getNumber() + (i*10);
                        }
                        shipTargets.add(TargetFactory.ceateTarget(offset + "", TargetStateFactory.createHealtyState()));
                    }
                    Ship ship = new Ship(shipTargets, f.getPlayerBoard().getCurrentShip());
                    f.getPlayerBoard().getBoard().getController().getShipFacade("player").setShip(ship);
                }
            }
        }else{
            if(f.getColor().equals(getSelectedBackgroundColor())){
                f.setColor(getHitColor());
            }else{
                f.setColor(getSeaColor());
            }
        }
    }

    private void drawNeighbours(Field f) {
        int xmin = 0;
        int xmax = 0;
        int ymin = 0;
        int ymax = 0;
        if (f.getPlayerBoard().getRichting() == 1) {
            xmin = f.getNumber() % 10;
            xmax = f.getNumber() % 10 + f.getPlayerBoard().getShipsize() - 1;
            ymin = f.getNumber() / 10;
            ymax = f.getNumber() / 10;
            if (f.getNumber() > 9) {
                ymin = ymin - 1;
            }
            if (f.getNumber() < 90) {
                ymax = ymax + 1;
            }
            if (f.getNumber() % 10 > 0) {
                xmin = xmin - 1;
            }
            if ((f.getNumber() % 10 + f.getPlayerBoard().getShipsize()) < 10) {
                xmax = xmax + 1;
            }
        }
        if (f.getPlayerBoard().getRichting() == 10) {
            xmin = f.getNumber() % 10;
            xmax = f.getNumber() % 10;
            ymin = f.getNumber() / 10;
            ymax = f.getNumber() / 10 + f.getPlayerBoard().getShipsize() - 1;
            if (f.getNumber() > 9) {
                ymin = ymin - 1;
            }
            if (f.getNumber() / 10 + f.getPlayerBoard().getShipsize() < 10) {
                ymax = ymax + 1;
            }
            if (f.getNumber() % 10 > 0) {
                xmin = xmin - 1;
            }
            if (f.getNumber() % 10 < 9) {
                xmax = xmax + 1;
            }
        }
        for (int x = xmin; x <= xmax; x++) {
            for (int y = ymin; y <= ymax; y++) {
                f.getPlayerBoard().getFields().get(y * 10 + x).setColor(getSeaColor());
            }
        }
    }

    private void drawShip(Field f, Color tileColor, Color borderColor) {
        int i = 0;

        while (i < f.getPlayerBoard().getShipsize() - 1) {

            Field middle = f.getPlayerBoard().getFields().get(f.getNumber() + i * f.getPlayerBoard().getRichting());
            Field right = f.getPlayerBoard().getFields().get(f.getNumber() + (f.getPlayerBoard().getShipsize() - 1) * f.getPlayerBoard().getRichting());
            if (f.getPlayerBoard().getRichting() == 1) {
                middle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, borderColor));
                f.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, borderColor));
                right.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, borderColor));
            } else {
                middle.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, borderColor));
                f.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, borderColor));
                right.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, borderColor));
            }
            middle.setColor(tileColor);
            right.setColor(tileColor);
            i++;
        }
    }

    private void unDrawShip(Field f) {
        f.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getStandardBorderColor()));
        f.setBackground(getStandardBackGroundColor());
        int i = 1;
        while (i <= f.getPlayerBoard().getShipsize() - 2) {
            Field middle = f.getPlayerBoard().getFields().get(f.getNumber() + i * f.getPlayerBoard().getRichting());
            middle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getStandardBorderColor()));
            middle.setBackground(getStandardBackGroundColor());
            i++;
        }
        Field right = f.getPlayerBoard().getFields().get(f.getNumber() + i * f.getPlayerBoard().getRichting());
        right.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getStandardBorderColor()));
        right.setBackground(getStandardBackGroundColor());
    }

    public boolean canDrawShip(int column, int row, int leftInt, Field f) {
        //Past in het veld?
        if (!(f.getPlayerBoard().getRichting() == 1 && f.getPlayerBoard().getShipsize() + column <= 10 || f.getPlayerBoard().getRichting() == 10 && f.getPlayerBoard().getShipsize() + row <= 10)) {
            return false;
        } else {
            int i = 1;
            while (i <= f.getPlayerBoard().getShipsize() - 1) {
                Field middle = f.getPlayerBoard().getFields().get(leftInt + i * f.getPlayerBoard().getRichting());
                if (middle.getColor().equals(getSelectedBackgroundColor()) || middle.getColor().equals(getSeaColor())) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
    public void clearSea(TreeMap<Integer,Field> fields){
        for(Field field : fields.values() ){
            if(field.getColor().equals(getSeaColor())){
                field.setColor(getStandardBackGroundColor());
            }
        }
    }

    public Color getStandardBorderColor() {
        return Color.black;
    }

    public  Color getSelectedBackgroundColor() {
        return Color.white;
    }

    public  Color getStandardBackGroundColor() {
        return Color.gray;
    }

    public  Color getHoverBackGroundColor() {
        return Color.PINK;
    }

    public  Color getSeaColor() {
        return Color.cyan;
    }

    public Color getHitColor(){
        return Color.red;
    }
}

