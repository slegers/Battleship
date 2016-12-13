package controller.ai.actions;

import controller.BattleshipController;
import controller.ai.Action;
import model.Ship;
import model.ShipFacade;
import model.factory.ShipFactory;
import model.type.ShipType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by covert on 13/12/16.
 */
public class PlaceShipAction implements Action {
	@Override
	public void doAction(BattleshipController battleshipController) {
		ShipFacade aiShipsFacade = battleshipController.getShipFacade("ai");
		Map<ShipType, Integer> varAvailableShipCount = aiShipsFacade.getAvailableShipCount();
		for (ShipType varShipType : ShipType.values()) {
			for (int i = 0; i < varAvailableShipCount.get(varShipType); i++) {
				try {
					Method createShipMethod = ShipFactory.class.getMethod("create" + varShipType.name(), Ship.class);
					createShipMethod.invoke(ShipFactory.class);
				} catch (NoSuchMethodException | IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
