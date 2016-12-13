package model.timer;

import controller.BattleshipController;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Dennis on 13/12/2016.
 */
public class BoardTimer {
    Timer boardTimer;
    BattleshipController controller;

    public BoardTimer(BattleshipController controller) {
        boardTimer = new Timer();
        this.controller = controller;
    }

    public void start(){
        boardTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                //TODO plaats schip
            }
        },30000);
    }

    public void stop(){
        boardTimer.cancel();
    }

}
