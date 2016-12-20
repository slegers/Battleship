package controller.ai;

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
import java.util.Map;
import java.util.Random;
import java.util.List;

/**
 * @author: Louis Roebben
 */
class PlaceShipAction implements Action {
	@Override
	public void doAction(BattleshipController battleshipController) {
		ShipFacade aiShipsFacade = battleshipController.getShipFacade("ai");
		Map<ShipType, Integer> varAvailableShipCount = aiShipsFacade.getAvailableShipCount();
		for (ShipType varShipType : ShipType.values()) {
			for (int i = 0; i < varAvailableShipCount.get(varShipType); i++) {
				try {
					Method createShipMethod = ShipFactory.class.getMethod("create" + varShipType.name() ,Ship.class);
					Ship ship = (Ship) createShipMethod.invoke(ShipFactory.class);

					int[] location = getRandomLocation(battleshipController);
					while (location[0] < varShipType.getSize() &&
							location[0] > battleshipController.getSettingsFacade().getHeight() + varShipType.getSize() &&
							location[1] < varShipType.getSize() &&
							location[1] > battleshipController.getSettingsFacade().getLength() + varShipType.getSize())
					{
						location = getRandomLocation(battleshipController);
					}
					ArrayList<Target> targets = new ArrayList<Target>();
					for (int count = 0; count < varShipType.getSize(); count++)
					{
						int[] finalLocation = location;
						int finalCount = count;
						if (location[2] == 0)
						{
							if (aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0]) + (finalLocation[1] + finalCount))))
							{
								this.doAction(battleshipController);
								return;
							}
						} else
						{
							if (aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0] + finalCount) + finalLocation[1])))
							{
								this.doAction(battleshipController);
								return;
							}
						}
					}
					for (int count = 0; count < varShipType.getSize(); count++)
					{
						if (location[2] == 0)
						{
							if (varShipType != ShipType.Submarine)
							{
								targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] + 1) + (location[1] + count), ship));
								targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] - 1) + (location[1] + count), ship));
							}

							targets.add(TargetFactory.createTarget(String.valueOf(location[0]) + (location[1] + count), ship));
						} else
						{
							if (varShipType != ShipType.Submarine)
							{
								targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] + count) + (location[1] + 1), ship));
								targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] + count) + (location[1] - 1), ship));
							}
							targets.add(TargetFactory.createTarget(String.valueOf(location[0] + count) + (location[1]), ship));
						}
					}
					ship.setTargets(targets);
					aiShipsFacade.setShip(ship);

				} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
				{
					e.printStackTrace();
				}
			}
		}

	}

	private int[] getRandomLocation(BattleshipController battleshipController)
	{
		Random random = new Random();
		String s = String.valueOf(battleshipController.getSettingsFacade().getLength());
		int[] i = new int[2];
		i[0] = (random.nextInt(Integer.parseInt(s)));
		i[1] = (random.nextInt(Integer.parseInt(s)));
		//TODO toch steeds out of bounds?
		i[2] = (random.nextInt(1));
		return i;
	}
}
