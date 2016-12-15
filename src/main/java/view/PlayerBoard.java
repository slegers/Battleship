package view;

import controller.ViewController;
import model.Ship;
import model.type.ShipType;
import model.timer.BoardTimer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
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
    // 1 = horizontaal
    // 10 = verticaal
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
    private void drawShip(Field left,Color tileColor,Color borderColor){
        int i = 0;

        while (i <= getShipsize() - 1) {

            Field middle = getFields().get(left.getNumber() + i * getRichting());
            if (getRichting() == 1) {
                middle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, borderColor));
                left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, borderColor));
            } else {
                middle.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, borderColor));
                left.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, borderColor));
            }
            middle.setColor(tileColor);
            i++;
        }

    }
    private void drawNeighbours(Field left) {
        ArrayList<Field> neightbours = getNeighbours(left);
        for(Field f : neightbours) {
            //f.setColor(getSeaColor());
        }
    }



    private ArrayList<Field> getNeighbours(Field f) {
        ArrayList<Field> neighbours = new ArrayList<Field>();
        if (richting == 1) {
            if (f.getNumber() > 9) {
                for (int i = 0; i < shipsize; i++) {
                    neighbours.add(fields.get(f.getNumber() - 10 + i));
                }
            }
            if (f.getNumber() < 90) {
                for (int i = 0; i < shipsize; i++) {
                    neighbours.add(fields.get(f.getNumber() + 10 + i));
                }
            }
            if (f.getNumber() % 10 > 0) {
                neighbours.add(fields.get(f.getNumber() - 1));
            }
            if ((f.getNumber() % 10 + shipsize) < 9) {
                neighbours.add(fields.get(f.getNumber() + shipsize));
            }
        }
        if (richting == 10) {
            if (f.getNumber() > 9) {
                neighbours.add(fields.get(f.getNumber() - 10));
            }
            if ((f.getNumber() + shipsize * 10) < 90) {
                neighbours.add(fields.get(f.getNumber() + shipsize * 10));
            }
            if (f.getNumber() % 10 > 0) {
                for (int i = 0; i < shipsize; i++) {
                    neighbours.add(fields.get(f.getNumber() - 1 + 10 * i));
                }
            }
            if (f.getNumber() % 10 < 9) {
                for (int i = 0; i < shipsize; i++) {
                    neighbours.add(fields.get(f.getNumber() + 1 + 10 * i));
                }
            }
        }
        return neighbours;
    }
    public void mouseEnter(Field f) {
        ViewController.mouseEnter(f);
    }
    public void mouseExit(Field f) {
        ViewController.mouseExit(f);
    }
    public void mouseClick(Field f){
        ViewController.mouseClick(f);
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
}
