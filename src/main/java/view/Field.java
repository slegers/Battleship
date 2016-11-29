package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Kevin on 23/11/2016.
 */
public class Field extends JPanel {


    private int fieldSize;
    private Color color;
    private PlayerBoard board;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

    public Field(int size, Color color, int number, PlayerBoard board){
        setFieldSize(size);
        setColor(color);
        setNumber(number);
        setPlayerBoard(board);
    }

    public void create(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(getFieldSize(),getFieldSize()));
        setBackground(getColor());
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getPlayerBoard().mouseEnter((Field)e.getSource());
            }

            @Override
            public void mouseExited(MouseEvent e){
                getPlayerBoard().mouseExit((Field)e.getSource());
            }

            @Override
            public void mouseClicked(MouseEvent e){
                getPlayerBoard().mouseClick((Field)e.getSource());
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
        setBackground(color);
    }

    public void setPlayerBoard(PlayerBoard board){
        this.board = board;
    }

    public PlayerBoard getPlayerBoard(){
        return this.board;
    }

}
