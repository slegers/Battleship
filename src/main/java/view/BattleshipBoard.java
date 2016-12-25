package view;

import com.sun.xml.internal.bind.v2.TODO;
import controller.BattleshipController;
import model.observer.Observer;
import model.type.ShipType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 18/11/16.
 *  @author yanice
 *  @autor Kevin
 */
public class BattleshipBoard extends JFrame implements Observer {
    JComboBox<String> ShipList;
    private BattleshipController controller;
    private PlayerBoard player1;
    private PlayerBoard player2;
    private int amountOfTiles;
    private int tileSize;
    private JButton button;
    private JLabel player1Label, player2Label;

    public BattleshipBoard(BattleshipController controller) {
        this.controller = controller;
        setAmountOfTiles(controller.getSettingsFacade().getLength());//10
        setTileSize(controller.getSettingsFacade().getHeight());//30
        createBoard();
    }

    public BattleshipController getController() {
        return controller;
    }

    public void createBoard() {
        JPanel options = createOptionsPanel();
        JPanel player1Panel = createPlayer1Panel();
        JPanel player2Panel = createPlayer2Panel();

        setLayout(new GridLayout(1, 3));
        this.setTitle("Zeeslag");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension((getAmountOfTiles() * getTileSize() + 50) * 3, (getAmountOfTiles() * getTileSize() + 80)));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        add(options);
        add(player1Panel);
        add(player2Panel);
    }

    private JPanel createOptionsPanel() {
        JPanel selectShip = selectShip();
        JPanel selectDirection = selectDirection();
        JPanel startButton = startButton();

        JPanel options = new JPanel();
        options.setPreferredSize(new Dimension(getAmountOfTiles() * getTileSize(), 15));
        options.setLayout(new GridLayout(3, 1));

        options.add(selectShip);
        options.add(selectDirection);
        options.add(startButton);

        return options;
    }

    private JPanel startButton() {
        JPanel startButton = new JPanel();
        startButton.setLayout(new GridBagLayout());

        button = new JButton("Start");
        button.setPreferredSize(new Dimension(getAmountOfTiles() * getTileSize() / 2, 30));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startGame(player1.getAmountOfShips(), player1.getFields());
            }
        });
        startButton.add(button);

        return startButton;
    }

    private JPanel selectDirection() {
        JPanel direction = new JPanel();
        JRadioButton horizontal = new JRadioButton("Horizontal");
        horizontal.setSelected(true);
        horizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getShipPlacementFacade().setDirectionOfPlayerBoard(player1, 1);
            }
        });
        JRadioButton vertical = new JRadioButton("Vertical");
        vertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getShipPlacementFacade().setDirectionOfPlayerBoard(player1, 10);
            }
        });
        ButtonGroup group = new ButtonGroup();
        group.add(horizontal);
        group.add(vertical);

        JLabel directiontitle = new JLabel("Richting:");
        directiontitle.setPreferredSize(new Dimension(getAmountOfTiles() * getTileSize(), 30));

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 2));
        buttons.add(horizontal);
        buttons.add(vertical);

        direction.add(directiontitle);
        direction.add(buttons);
        return direction;
    }

    private JPanel selectShip() {
        String[] ships = new String[ShipType.values().length];
        int i = 0;
        for (ShipType schip : ShipType.values()) {
            ships[i] = schip.toString() + " (" + getController().getShipFacade("player").getAvailableShipCount().get(schip) + ")";
            i++;
        }
        ShipList = new JComboBox<>(ships);
        ShipList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getShipPlacementFacade().setShipTypeOfPlayerBoard(player1, ShipType.valueOf((ShipList.getSelectedItem().toString()).split(" ")[0]));
            }
        });
        JLabel shipsTitle = new JLabel("Beschikbare schepen:");
        shipsTitle.setPreferredSize(new Dimension(getAmountOfTiles() * getTileSize(), 30));

        JPanel selectShip = new JPanel();
        selectShip.setLayout(new FlowLayout());
        selectShip.setPreferredSize(new Dimension(getAmountOfTiles() * getTileSize(), 30));
        selectShip.add(shipsTitle);
        selectShip.add(ShipList);
        return selectShip;
    }

    private JPanel createPlayer1Panel() {
        JPanel player1Panel = new JPanel();
        player1Panel.setLayout(new FlowLayout());
        player1Label = new JLabel(getController().getSettingsFacade().getNamePlayer1());
        player1Label.setPreferredSize(new Dimension(getAmountOfTiles() * getTileSize(), 15));
        player1Label.setHorizontalAlignment(SwingConstants.CENTER);
        player1 = new PlayerBoard(getTileSize(), getAmountOfTiles() * getAmountOfTiles(), this);
        player1Panel.add(player1Label);
        player1Panel.add(player1);
        return player1Panel;
    }

    private JPanel createPlayer2Panel() {
        JPanel player2Panel = new JPanel();
        player2Panel.setLayout(new FlowLayout());
        player2Label = new JLabel(getController().getSettingsFacade().getNamePlayer2());
        player2Label.setPreferredSize(new Dimension(getAmountOfTiles() * getTileSize(), 15));
        player2Label.setHorizontalAlignment(SwingConstants.CENTER);
        player2 = new PlayerBoard(getTileSize(), getAmountOfTiles() * getAmountOfTiles(), this);
        player2.setEnabled(false);
        player2Panel.add(player2Label);
        player2Panel.add(player2);
        return player2Panel;
    }

    public int getAmountOfTiles() {
        return amountOfTiles;
    }

    public void setAmountOfTiles(int amountOfTiles) {
        this.amountOfTiles = amountOfTiles;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public void startGame() {
        button.setEnabled(false);
        player1.setEnabled(false);
        player2.setEnabled(true);
    }

    public void update() {
        player1Label.setText(getController().getSettingsFacade().getNamePlayer1() + " ( " + (controller.getSettingsFacade().getMaxScore() - controller.getShipFacade("player").getSucessfulHits()) + " )");
        player2Label.setText(getController().getSettingsFacade().getNamePlayer2() + " ( " + (controller.getSettingsFacade().getMaxScore() - controller.getShipFacade("ai").getSucessfulHits()) + " )");


        repaint();
        revalidate();
    }

    @Override
    public void update(String target) {
        player1.getFields().get(Integer.parseInt(target)).setColor(Color.cyan);
        //TODO:  louis recaftor with is hit ...
    }
}
