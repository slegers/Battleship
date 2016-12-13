package model.timer;

import controller.BattleshipController;
import model.Ship;
import model.ShipFacade;
import model.factory.ShipFactory;
import model.type.ShipType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
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
	            ShipFacade aiShipsFacade = controller.getShipFacade("ai");
	            Map<ShipType, Integer> varAvailableShipCount = aiShipsFacade.getAvailableShipCount();
	            for (ShipType varShipType : ShipType.values()) {
		            if (varShipType.getMaxShips() < varAvailableShipCount.get(varShipType)) {
			            try {
				            Method createShipMethod = ShipFactory.class.getMethod("create" + varShipType.name(), Ship.class);
				            Ship ship = (Ship) createShipMethod.invoke(ShipFactory.class);
			            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				            e.printStackTrace();
			            }
			            return;
		            }
	            }

            }
        },30000);
    }

    public void stop(){
        boardTimer.cancel();
    }

}
