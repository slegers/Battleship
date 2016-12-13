package view;

import javax.swing.*;

/**
 * Created by yanice on 13/12/16.
 */
public class dummy {
/*
    public void mouseEnter(Field left) {
        if (isEnabled() && !left.isoccupied()) {
            int column = left.getNumber() % 10;
            int row = left.getNumber() / 10;
            if ((getRichting() == 1 && getShipsize() + column <= 10) || (getRichting() == 10 && getShipsize() + row <= 10)) {
                if (getRichting() == 1) {
                    left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, getStandardBorderColor()));
                } else {
                    left.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, getStandardBorderColor()));
                }
                left.setColor(getSelectedBackgroundColor());
                int i = 1;
                while (i <= getShipsize() - 2) {
                    Field middle = getFields().get(left.getNumber() + i * getRichting());
                    if (getRichting() == 1) {
                        middle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, getStandardBorderColor()));
                    } else {
                        middle.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, getStandardBorderColor()));
                    }
                    middle.setColor(getSelectedBackgroundColor());
                    i++;
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
        if (isEnabled() && !isClicked() && !left.isoccupied()) {
            int column = left.getNumber() % 10;
            int row = left.getNumber() / 10;
            if ((getRichting() == 1 && getShipsize() + column <= 10) || (getRichting() == 10 && getShipsize() + row <= 10)) {
                left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getStandardBorderColor()));
                left.setBackground(getStandardBackGroundColor());
                int i = 1;
                while (i <= getShipsize() - 2) {
                    Field middle = getFields().get(left.getNumber() + i * getRichting());
                    if(!middle.isoccupied()) {
                        middle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getStandardBorderColor()));
                        middle.setBackground(getStandardBackGroundColor());
                    }
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
        left.setOccupied(true);
        int column = left.getNumber() % 10;
        int row = left.getNumber() / 10;
        if ((getRichting() == 1 && getShipsize() + column <= 10) || (getRichting() == 10 && getShipsize() + row <= 10)) {
            left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getSelectedBackgroundColor()));
            left.setBackground(getStandardBackGroundColor());
            int i = 1;
            while (i <= getShipsize() - 2) {
                Field middle = getFields().get(left.getNumber() + i * getRichting());
                if(!middle.isoccupied()) {
                    middle.setOccupied(true);
                    middle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getSelectedBackgroundColor()));
                    middle.setBackground(getStandardBackGroundColor());
                }
                i++;
            }
            Field right = getFields().get(left.getNumber() + i * getRichting());
            right.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, getSelectedBackgroundColor()));
            right.setBackground(getStandardBackGroundColor());
        }
    }
}*/
}
