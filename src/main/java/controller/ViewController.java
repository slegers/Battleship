package controller;

import model.type.ShipType;
import view.Field;
import view.PlayerBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Kevin on 15/12/2016.
 * @author Kevin
 */
public class ViewController {
    public static void setDirectionOfPlayerBoard(PlayerBoard board, int direction){
        board.setRichting(direction);
    }
    public static void setShipTypeOfPlayerBoard(PlayerBoard board, ShipType type){
        board.setCurrentShip(type);
        board.setShipsize(type.getSize());
    }
    public static void mouseEnter(Field f){
        int column = f.getNumber() % 10;
        int row = f.getNumber() / 10;
        if(f.getBackground().equals(getStandardBackGroundColor()) && f.getPlayerBoard().isEnabled() && canDrawShip(column,row,f.getNumber(),f)){
            drawShip(f,getHoverBackGroundColor(),getHoverBackGroundColor());
        }
    }

    public static void mouseExit(Field f){
        if (f.getPlayerBoard().isEnabled() && f.getBackground().equals(getHoverBackGroundColor()) && f.getPlayerBoard().isEnabled()) {
            int column = f.getNumber() % 10;
            int row = f.getNumber() / 10;
            if(canDrawShip(column,row,f.getNumber(),f)){
                unDrawShip(f);
            }
        }
    }

    public static void mouseClick(Field f){
        if(f.getPlayerBoard().getCurrentShip().getMaxShips() <= 0){
            JOptionPane.showMessageDialog(null,"You already have too much ships of this type.");
        }else{
            int column = f.getNumber() % 10;
            int row = f.getNumber() / 10;
            if(f.getPlayerBoard().isEnabled() && canDrawShip(column,row,f.getNumber(),f)){
                drawShip(f,getSelectedBackgroundColor(),getStandardBorderColor());
                drawNeighbours(f);
            }
            f.getPlayerBoard().getCurrentShip().setMaxShips(f.getPlayerBoard().getCurrentShip().getMaxShips()-1);
        }
    }

    private static void drawNeighbours(Field left) {
        ArrayList<Field> neightbours = getNeighbours(left);
        for(Field f : neightbours) {
            f.setColor(getSeaColor());
        }
    }

    private static ArrayList<Field> getNeighbours(Field f) {
        ArrayList<Field> neighbours = new ArrayList<Field>();
        if(f.getPlayerBoard().getRichting() == 1){
            if(f.getNumber() > 9){
                for(int i = 0; i < f.getPlayerBoard().getShipsize(); i++){
                    neighbours.add(f.getPlayerBoard().getFields().get(f.getNumber()- 10 + i));
                }
            }
            if(f.getNumber() < 90){
                for(int i = 0; i < f.getPlayerBoard().getShipsize(); i++){
                    neighbours.add(f.getPlayerBoard().getFields().get(f.getNumber()+ 10 + i));
                }
            }
            if(f.getNumber() %10 > 0){
                neighbours.add(f.getPlayerBoard().getFields().get(f.getNumber()-1));
            }
            if((f.getNumber() % 10 + f.getPlayerBoard().getShipsize()) < 9){
                neighbours.add(f.getPlayerBoard().getFields().get(f.getNumber()+f.getPlayerBoard().getShipsize()));
            }
        }
        if(f.getPlayerBoard().getRichting() == 10){
            if(f.getNumber() > 9){
                neighbours.add(f.getPlayerBoard().getFields().get(f.getNumber()-10));
            }
            if((f.getNumber() + f.getPlayerBoard().getShipsize() * 10) < 90){
                neighbours.add(f.getPlayerBoard().getFields().get(f.getNumber()+f.getPlayerBoard().getShipsize()*10));
            }
            if(f.getNumber() %10 > 0){
                for(int i = 0; i < f.getPlayerBoard().getShipsize(); i++){
                    neighbours.add(f.getPlayerBoard().getFields().get(f.getNumber() -1 + 10 * i));
                }
            }
            if(f.getNumber() % 10 < 9){
                for(int i = 0; i < f.getPlayerBoard().getShipsize(); i++){
                    neighbours.add(f.getPlayerBoard().getFields().get(f.getNumber() +1 + 10 * i));
                }
            }
        }
        return neighbours;
    }

    private static void drawShip(Field f, Color tileColor, Color borderColor){
        int i = 0;

        while (i <= f.getPlayerBoard().getShipsize() - 1) {

            Field middle = f.getPlayerBoard().getFields().get(f.getNumber() + i * f.getPlayerBoard().getRichting());
            if (f.getPlayerBoard().getRichting() == 1) {
                middle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, borderColor));
                f.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, borderColor));
            } else {
                middle.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, borderColor));
                f.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, borderColor));
            }
            middle.setColor(tileColor);
            i++;
        }
    }
    private static void unDrawShip(Field f){
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

    public static boolean canDrawShip(int column, int row, int leftInt, Field f){
        //Past in het veld?
        if(!(f.getPlayerBoard().getRichting() == 1 && f.getPlayerBoard().getShipsize() + column <= 10 || f.getPlayerBoard().getRichting() == 10 && f.getPlayerBoard().getShipsize() + row <=10)){
            return false;
        }
        else{
            int i = 1;
            while (i <= f.getPlayerBoard().getShipsize() - 1) {
                Field middle = f.getPlayerBoard().getFields().get(leftInt + i * f.getPlayerBoard().getRichting());
                if(middle.getColor().equals(getSelectedBackgroundColor()) || middle.getColor().equals(getSeaColor())){
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static Color getStandardBorderColor(){
        return Color.black;
    }

    public static Color getSelectedBackgroundColor(){
        return Color.white;
    }

    public static Color getStandardBackGroundColor(){
        return Color.gray;
    }

    public static Color getHoverBackGroundColor(){
        return Color.PINK;
    }

    public static Color getSeaColor() {
        return Color.cyan;
    }
}
