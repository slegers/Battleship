package view;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

/**
 * Created by Kevin on 23/11/2016.
 */
public class PlayerBoard extends JPanel {
    TreeMap<Integer, Field> fields = new TreeMap<Integer, Field>();
    int shipsize = 3;
    int richting = 10;

    private int fieldsize;
    private JLabel nameJlabel;

    public  PlayerBoard(int fieldsize,int amountOfTiles){
        setSize(new Dimension(400,400));
        setLayout(new GridLayout((int)Math.sqrt(amountOfTiles),(int)Math.sqrt(amountOfTiles)));
        for(int i = 0; i < amountOfTiles; i++){

            Field field = new Field(fieldsize,Color.gray,i, this);
            field.create();
            //field.setText(i+"");
            fields.put(i,field);
            add(field);
        }
    }

    public void mouseEnter(Field left){
        if(richting == 1) {
            left.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
            left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black));
        } else{
            left.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
            left.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black));
        }
        left.setBackground(Color.white);
        int i = 1;
        while(i<=shipsize-2){
            Field middle = fields.get(left.getNumber()+i*richting);
            if(richting == 1) {
                middle.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.gray));
                middle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            } else{
                middle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.gray));
                middle.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black));
            }
            middle.setBackground(Color.white);
            i++;
        }
        Field right = fields.get(left.getNumber()+i*richting);
        if(richting == 1) {
            right.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.gray));
            right.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
        } else{
            right.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
            right.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
        }
        right.setBackground(Color.white);
    }

    public void mouseExit(Field left){
        left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        left.setBackground(left.getColor());
        int i = 1;
        while(i<=shipsize-2){
            Field middle = fields.get(left.getNumber()+i*richting);
            middle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            middle.setBackground(middle.getColor());
            i++;
        }
        Field right = fields.get(left.getNumber()+i*richting);
        right.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        right.setBackground(right.getColor());
    }


}
