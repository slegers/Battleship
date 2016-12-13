package model.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Dennis on 13/12/2016.
 */
public class BoardTimer {
    Timer boardTimer;

    public BoardTimer(){
        boardTimer = new Timer();
    }

    public void start(){
        boardTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                stop();
            }
        },30000);
    }

    public void stop(){

    }

}
