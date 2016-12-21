package model.ai;

import controller.BattleshipController;
import model.Ship;
import model.ShipFacade;
import model.Target;
import model.TargetFactory;
import model.factory.ShipFactory;
import model.type.ShipType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author: Louis Roebben
 */
class PlaceShipAction implements Action {
	@Override
	public void doAction(BattleshipController battleshipController) {
		ShipFacade aiShipsFacade = battleshipController.getShipFacade("ai");
		Map<ShipType, Integer> varAvailableShipCount = aiShipsFacade.getAvailableShipCount();
		//TODO from settings
		int maxShips = 5;
		int iCount = 0;
		for (ShipType varShipType : ShipType.values()) {
			if (iCount > maxShips) return;
			iCount++;
			shipplaceloop:
			for (int i = 0; i < varAvailableShipCount.get(varShipType); i++) {
				try {

					int[] location = getRandomLocation(battleshipController);
					while (location[0] < varShipType.getSize() &&
							location[0] > battleshipController.getSettingsFacade().getHeight() + varShipType.getSize() &&
							location[1] < varShipType.getSize() &&
							location[1] > battleshipController.getSettingsFacade().getLength() + varShipType.getSize()) {
						location = getRandomLocation(battleshipController);
					}
					ArrayList<Target> targets = new ArrayList<>();
					for (int count = 0; count < varShipType.getSize(); count++) {
						int[] finalLocation = location;
						int finalCount = count;
						if (location[2] == 0) {
							if (aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0]) + (finalLocation[1] + finalCount)))
									|| aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0] + 1) + (finalLocation[1] + finalCount)))
									|| aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0] - 1) + (finalLocation[1] + finalCount)))) {
								break shipplaceloop;
							}
						} else {
							if (aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0] + finalCount) + finalLocation[1]))
									|| aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0] + finalCount) + (finalLocation[1] + 1)))
									|| aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0] + finalCount) + (finalLocation[1] - 1)))) {
								break shipplaceloop;
							}
						}
					}
					for (int count = 0; count < varShipType.getSize(); count++) {
						if (location[2] == 0) {
							//Sides
							targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] + 1) + (location[1] + count)));
							targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] - 1) + (location[1] + count)));

							targets.add(TargetFactory.createTarget(String.valueOf(location[0]) + (location[1] + count)));
						} else {
							//Sides
							targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] + count) + (location[1] + 1)));
							targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] + count) + (location[1] - 1)));

							targets.add(TargetFactory.createTarget(String.valueOf(location[0] + count) + (location[1])));
						}
					}
					Method createShipMethod = ShipFactory.class.getMethod("create" + varShipType.name(), List.class, ShipFacade.class);
					createShipMethod.invoke(new ShipFactory() {
					}, targets, aiShipsFacade);
					//ship.setTargets(targets);
					//aiShipsFacade.setShip(ship);

				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException ex) {
					System.out.println(varShipType.name());
				}
				System.out.println("placing done");
			}
		}
		System.out.println(battleshipController.getShipFacade("ai").getAllShips().size());
		for(Ship ship : battleshipController.getShipFacade("ai").getAllShips()){
			System.out.print(ship.getType().toString());
			for(Target t: ship.getTargets()){
				System.out.print(", " +  t.getName() + " " +  t.getState().getName());
			}
			System.out.println();
		}
	}

	private int[] getRandomLocation(BattleshipController battleshipController)
	{
		Random random = new Random();
		String s = String.valueOf(battleshipController.getSettingsFacade().getLength());
		int[] i = new int[3];
		i[0] = (random.nextInt(Integer.parseInt(s)));
		i[1] = (random.nextInt(Integer.parseInt(s)));
		i[2] = (random.nextInt(1));
		return i;
	}
}
