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
