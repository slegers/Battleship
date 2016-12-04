package view;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

/**
 * Created by Kevin on 23/11/2016.
 */
public class PlayerBoard extends JPanel {

    TreeMap<Integer, Field> fields = new TreeMap<Integer, Field>();
    int shipsize = 5;
    int richting = 1;
    boolean enabled = true;
    boolean clicked = false;

    public  PlayerBoard(int fieldSize,int amountOfTiles){
        setSize(new Dimension(400,400));
        setLayout(new GridLayout((int)Math.sqrt(amountOfTiles),(int)Math.sqrt(amountOfTiles)));
        for(int i = 0; i < amountOfTiles; i++){

            Field field = new Field(fieldSize,Color.gray,i, this);
            field.create();
            getFields().put(i,field);
            add(field);
        }
    }
    public boolean changeColor(){
        return false;
    }
    public void mouseEnter(Field left) {
        if (isEnabled() && !left.isoccupied()) {
            int column = left.getNumber() % 10;
            int row = left.getNumber() / 10;
            if ((getRichting() == 1 && getShipsize() + column <= 10) || (getRichting() == 10 && getShipsize() + row <= 10) && !left.getColor().equals(getSelectedBackgroundColor())) {
                if (getRichting() == 1 && !left.isoccupied()) {
                    left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, getStandardBorderColor()));
                } else if (!left.isoccupied()) {
                    left.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, getStandardBorderColor()));
                }
                left.setColor(getSelectedBackgroundColor());
                int i = 1;
                while (i <= getShipsize() - 2) {
                    Field middle = getFields().get(left.getNumber() + i * getRichting());
                    if (!middle.isoccupied()) {
                        if (getRichting() == 1 && !middle.isoccupied()) {
                            middle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, getStandardBorderColor()));
                            middle.setColor(getSelectedBackgroundColor());
                        } else if (!middle.isoccupied()) {
                            middle.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, getStandardBorderColor()));
                            middle.setColor(getSelectedBackgroundColor());
                        }

                        i++;
                    }
                }
                Field right = getFields().get(left.getNumber() + i * getRichting());
                if (getRichting() == 1) {
                    right.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, getStandardBorderColor()));
                } else {
                    right.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, getStandardBorderColor()));
                }
                right.setColor(getSelectedBackgroundColor());
            }
        }
    }


    public void mouseExit(Field left) {
        if(isEnabled() && !left.isoccupied()){
            left.setBackground(getStandardBackGroundColor());
        }
         if (isEnabled() && !clicked && !left.isoccupied()) {
            int column = left.getNumber() % 10;
            int row = left.getNumber() / 10;
            if ((getRichting() == 1 && getShipsize() + column <= 10) || (getRichting() == 10 && getShipsize() + row <= 10)) {
                left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getStandardBorderColor()));
                left.setBackground(getStandardBackGroundColor());
                int i = 1;
                while (i <= getShipsize() - 2) {
                    Field middle = getFields().get(left.getNumber() + i * getRichting());
                    middle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getStandardBorderColor()));
                    middle.setBackground(getStandardBackGroundColor());
                    i++;
                }
                Field right = getFields().get(left.getNumber() + i * getRichting());
                right.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getStandardBorderColor()));
                right.setBackground(getStandardBackGroundColor());
            }
        }
        clicked = false;
    }
    public void mouseClick(Field left){
        clicked = true;
        if (isEnabled()) {
            int column = left.getNumber() % 10;
            int row = left.getNumber() / 10;
            if ((getRichting() == 1 && getShipsize() + column <= 10) || (getRichting() == 10 && getShipsize() + row <= 10)) {
                if (getRichting() == 1) {
                    left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, getSelectedBackgroundColor()));
                } else {
                    left.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, getSelectedBackgroundColor()));
                }
                left.setOccupied(true);
                left.setColor(getSelectedBackgroundColor());
                int i = 1;
                while (i <= getShipsize() - 2) {
                    Field middle = getFields().get(left.getNumber() + i * getRichting());
                    if (getRichting() == 1) {
                        middle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, getSelectedBackgroundColor()));
                    } else {
                        middle.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, getSelectedBackgroundColor()));
                    }
                    middle.setOccupied(true);
                    middle.setColor(getSelectedBackgroundColor());
                    i++;
                }
                Field right = getFields().get(left.getNumber() + i * getRichting());
                if (getRichting() == 1) {
                    right.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, getSelectedBackgroundColor()));
                } else {
                    right.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, getStandardBorderColor()));
                }
                right.setOccupied(true);
                right.setColor(getSelectedBackgroundColor());
            }
        }

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

    public Color getStandardBorderColor(){
        return Color.black;
    }

    public Color getSelectedBackgroundColor(){
        return Color.white;
    }

    public Color getStandardBackGroundColor(){
        return Color.gray;
    }

    public boolean isClicked() {
        return clicked;
    }
}
