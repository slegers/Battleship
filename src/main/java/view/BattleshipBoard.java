package view;

import controller.BattleshipController;
import model.settings.SettingsFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 18/11/16.
 */
public class BattleshipBoard extends JFrame{
    private BattleshipController controller;
    private PlayerBoard player1;
    private PlayerBoard player2;

    public BattleshipBoard(BattleshipController controller) {
        this.controller = controller;
        createBoard();
    }

    public BattleshipController getController(){
        return controller;
    }

    public void createBoard(){

        JPanel options = new JPanel();
        options.setPreferredSize(new Dimension(300,15));
        String[] ships = getController().getSettingsFacade().ge
        String[] bookTitles = new String[] {"Effective Java", "Head First Java",
                "Thinking in Java", "Java for Dummies"};
        JComboBox<String> bookList = new JComboBox<>(bookTitles);
        bookList.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println((String) bookList.getSelectedItem());
            }
        });
        options.add(bookList);

        JPanel player1Panel = new JPanel();
        player1Panel.setLayout(new FlowLayout());
        JLabel player1Label = new JLabel(getController().getSettingsFacade().getNamePlayer1());
        player1Label.setPreferredSize(new Dimension(300,15));
        player1Label.setHorizontalAlignment(SwingConstants.CENTER);
        player1 = new PlayerBoard(30,100);
        player1Panel.add(player1Label);
        player1Panel.add(player1);

        JPanel player2Panel = new JPanel();
        player2Panel.setLayout(new FlowLayout());
        JLabel player2Label = new JLabel(getController().getSettingsFacade().getNamePlayer2());
        player2Label.setPreferredSize(new Dimension(300,15));
        player2Label.setHorizontalAlignment(SwingConstants.CENTER);
        player2 = new PlayerBoard(30,100);
        player2Panel.add(player2Label);
        player2Panel.add(player2);

        setLayout(new GridLayout(1,3));
        add(options);
        add(player1Panel);
        add(player2Panel);

        this.setTitle("Zeeslag");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1050,380));
        //this.setBounds(0,0,100,200);
        //this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
