package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Peelm on 23/11/2016.
 */
public class Field extends JLabel {

    private int fieldSize;
    private Color color;

    public Field(int size, Color color){
        setFieldSize(size);
        setColor(color);
    }

    public void create(){
        setSize(new Dimension(getFieldSize(),getFieldSize()));
        setBackground(getColor());
        setVisible(true);
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
