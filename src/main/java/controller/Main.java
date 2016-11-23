package controller;

import view.BattleshipBoard;

/**
 * Created by yanice on 18/11/16.
 */
public class Main {
    public static void main(String[] args) {
        BattleshipController controller = new BattleshipController();
        BattleshipBoard view = new BattleshipBoard(controller);
    }
}
