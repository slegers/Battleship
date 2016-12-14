package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.TreeMap;

/**
 * Created by Kevin on 23/11/2016.
 * @author yanice
 */
public class PlayerBoard extends JPanel {

    TreeMap<Integer, Field> fields = new TreeMap<Integer, Field>();
    int shipsize = 5;
    // 1 = horizontaal
    // 0 = verticaal
    int richting = 1;
    boolean enabled = true;

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

    public void mouseEnter(Field left) {
        int column = left.getNumber() % 10;
        int row = left.getNumber() / 10;
        if(left.getBackground().equals(getStandardBackGroundColor()) && isEnabled() && canDrawShip(column,row,left.getNumber(),left)){
            drawShip(left,getHoverBackGroundColor(),getHoverBackGroundColor());
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
        int i = -1;
        while (i <= getShipsize()) {
            Field middle = getFields().get(left.getNumber() + i * getRichting());
            Field above = getFields().get(middle.getNumber() + 10);
            Field under =  getFields().get(middle.getNumber() - 10 );
            if (getRichting() == 1) {
                above.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, getSeaColor()));
                above.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, getSeaColor()));
                under.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, getSeaColor()));
                under.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, getSeaColor()));
            } else {
                above.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, getSeaColor()));
                above.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, getSeaColor()));
                under.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, getSeaColor()));
                under.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, getSeaColor()));
            }
            above.setColor(Color.cyan);
            under.setColor(Color.cyan);
            i++;
        }
        Field leftTile = getFields().get(left.getNumber() - 1);
        Field RightTile = getFields().get(left.getNumber() + getShipsize());
        leftTile.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, getSeaColor()));
        leftTile.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, getSeaColor()));
        RightTile.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, getSeaColor()));
        RightTile.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, getSeaColor()));
        leftTile.setColor(getSeaColor());
        RightTile.setColor(getSeaColor());


    }

    private void unDrawShip(Field left,Color a,Color borderColor){
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
    public boolean canDrawShip(int column, int row,int leftInt,Field left){
        //Past in het veld?
        if(!(getRichting() == 1 && getShipsize() + column <= 10 || getRichting() == 10 && getShipsize() + row <=10)){
            return false;
        }
        else{
            int i = 1;
            while (i <= getShipsize() - 1) {
                Field middle = getFields().get(leftInt + i * getRichting());
                if(middle.getColor().equals(getSelectedBackgroundColor()) || middle.getColor().equals(getSeaColor())){
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public void mouseExit(Field left) {
            if (isEnabled() && left.getBackground().equals(getHoverBackGroundColor()) && isEnabled()) {
                int column = left.getNumber() % 10;
                int row = left.getNumber() / 10;
                if(canDrawShip(column,row,left.getNumber(),left)){
                    unDrawShip(left,getStandardBackGroundColor(),getStandardBorderColor());
                }
        }
    }
    public void mouseClick(Field left){
        int column = left.getNumber() % 10;
        int row = left.getNumber() / 10;
        if(isEnabled() && canDrawShip(column,row,left.getNumber(),left)){
            drawShip(left,getSelectedBackgroundColor(),getStandardBorderColor());
            drawNeighbours(left);
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

    public Color getHoverBackGroundColor(){
        return Color.PINK;
    }

    public Color getSeaColor() {
        return Color.cyan;
    }
}
