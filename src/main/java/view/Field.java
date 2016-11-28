package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Peelm on 23/11/2016.
 */
public class Field extends JPanel {

    private int fieldSize;
    private Color color;

    public Field(int size, Color color){
        setFieldSize(size);
        setColor(color);
    }

    public void create(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(getFieldSize(),getFieldSize()));
        setBackground(getColor());
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.blue);
            }
        });
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
