package view;

import javax.swing.*;

/**
 * Created by yanice on 25/12/16.
 */
public class ShowWinner extends JOptionPane {

    public ShowWinner(String winner, int points){
        showMessageDialog(null,"The winner of this game is " + winner + "with " + points + " points.");
    }

}
