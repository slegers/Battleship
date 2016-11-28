package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Kevin on 23/11/2016.
 */
public class PlayerBoard extends JPanel {
    TreeMap<Integer, Field> fields = new TreeMap<Integer, Field>();
    private int fieldsize;

    public PlayerBoard(int fieldsize, int amountOfFields){
        setSize(new Dimension(600,600));

        setLayout(new GridLayout((int)Math.sqrt(amountOfFields),(int)Math.sqrt(amountOfFields)));
        for(int i = 0; i < amountOfFields; i++){
            Field field = new Field(fieldsize,Color.gray);
            field.create();
            //field.setText(i+"");
            if(i == 33 || i == 34){
                field.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.gray));
                field.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            }
            fields.put(i,field);
            add(field);
        }
    }
}
