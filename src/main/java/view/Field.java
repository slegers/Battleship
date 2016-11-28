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
                //setBackground(Color.blue);
                setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
                setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black));
                setBackground(Color.white);
                Field left = getPlayerBoard().fields.get(number+1);
                left.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.gray));
                left.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
                left.setBackground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e){
                setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                setBackground(getColor());
                Field left = getPlayerBoard().fields.get(number+1);
                left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                left.setBackground(left.getColor());
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

    public void setPlayerBoard(PlayerBoard board){
        this.board = board;
    }

    public PlayerBoard getPlayerBoard(){
        return this.board;
    }

}
