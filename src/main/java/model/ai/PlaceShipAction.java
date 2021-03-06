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
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Louis Roebben
 */
class PlaceShipAction implements Action {
	@Override
	public void doAction(BattleshipController battleshipController) {
		ShipFacade aiShipsFacade = battleshipController.getShipFacade("ai");
		Map<ShipType, Integer> varAvailableShipCount = aiShipsFacade.getAvailableShipCount();
		int maxShips = battleshipController.getSettingsFacade().getMaxShips();
		int iCount = 0;
		for (ShipType varShipType : ShipType.values()) {
			shipBreakLoop:
			for (int i = 0; i < varAvailableShipCount.get(varShipType); i++)
			{
				if (iCount >= maxShips)
				{
					battleshipController.getAiFacade().placingDone();
					return;
				}
				try {

					int[] location = getRandomLocation(battleshipController);
					while (location[0] > battleshipController.getSettingsFacade().getHeight() - varShipType.getSize() &&
							location[1] > battleshipController.getSettingsFacade().getLength() - varShipType.getSize())
					{
						location = getRandomLocation(battleshipController);
					}
					ArrayList<Target> targets = new ArrayList<>();
					for (int count = 0; count < varShipType.getSize(); count++) {
						int[] finalLocation = location;
						int finalCount = count;
						if (location[2] == 0) {
							if (aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0]) + (finalLocation[1] + finalCount)))
									|| finalLocation[0] < 0 || finalLocation[0] > battleshipController.getSettingsFacade().getHeight()
									|| finalLocation[1] < 0 || finalLocation[1] > battleshipController.getSettingsFacade().getLength())
							{
								i--;//WARNING SIDE EFFECT
								//iCount--;
								continue shipBreakLoop;
							}
						} else {
							if (aiShipsFacade.getAllShips().stream().anyMatch(obj ->
									obj.inhabitsTarget(String.valueOf(finalLocation[0] + finalCount) + finalLocation[1]))
									|| finalLocation[0] < 0 || finalLocation[0] < battleshipController.getSettingsFacade().getHeight()
									|| finalLocation[1] < 0 || finalLocation[1] < battleshipController.getSettingsFacade().getLength())
							{
								i--;//WARNING SIDE EFFECT
								//iCount--;
								continue shipBreakLoop;
							}
						}
					}
					for (int count = -1; count < varShipType.getSize(); count++) {
						if (location[2] == 0) {
							//Sides
							String sideA = String.valueOf(location[0] + 1) + (location[1] + count);
							String sideB = String.valueOf(location[0] - 1) + (location[1] + count);
							if (Integer.parseInt(sideA) > 0)
								targets.add(TargetFactory.createForbiddenTarget(sideA));
							if (Integer.parseInt(sideB) > 0)
								targets.add(TargetFactory.createForbiddenTarget(sideB));
							if (Integer.parseInt(sideA) > 0 && Integer.parseInt(sideB) > 0 && count < 0)
							{
								targets.add(TargetFactory.createForbiddenTarget(sideA));
								targets.add(TargetFactory.createForbiddenTarget(sideB));
								targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0]) + (location[1] + count)));
							} else
							{
								targets.add(TargetFactory.createTarget(String.valueOf(location[0]) + (location[1] + count)));
							}
						} else {
							//Sides
							String sideA = String.valueOf(location[0] + count) + (location[1] + 1);
							String sideB = String.valueOf(location[0] + count) + (location[1] - 1);
							if (Integer.parseInt(sideA) > 0)
								targets.add(TargetFactory.createForbiddenTarget(sideA));
							if (Integer.parseInt(sideB) > 0)
								targets.add(TargetFactory.createForbiddenTarget(sideB));
							if (Integer.parseInt(sideA) > 0 && Integer.parseInt(sideB) > 0 && count < 0)
							{
								targets.add(TargetFactory.createForbiddenTarget(sideA));
								targets.add(TargetFactory.createForbiddenTarget(sideB));
								targets.add(TargetFactory.createForbiddenTarget(String.valueOf(location[0] + count) + (location[1])));
							} else
							{
								targets.add(TargetFactory.createTarget(String.valueOf(location[0] + count) + (location[1])));
							}
						}
					}
					System.out.println("adding");
					Method createShipMethod = ShipFactory.class.getMethod("create" + varShipType.name(), List.class, ShipFacade.class);
					createShipMethod.invoke(new ShipFactory() {}, targets, aiShipsFacade);
					//ship.setTargets(targets);
					//aiShipsFacade.setShip(ship);

				} catch (IllegalAccessException e)
				{
					e.printStackTrace();
				} catch (InvocationTargetException e)
				{
					e.getTargetException();
				} catch (NoSuchMethodException ex) {
					System.out.println(varShipType.name());
				}
				iCount++;
				System.out.println("placing done " + iCount);
			}
	}
		System.out.println(battleshipController.getShipFacade("ai").getAllShips().size());
		for(Ship ship : battleshipController.getShipFacade("ai").getAllShips()){
			System.out.print(ship.getType().toString());
			for(Target t: ship.getTargets()){
				System.out.print(", " +  t.getName() + " " +  t.getState().getName());
			}
		}
		assert false;
		//Should never be here
		//got to love goto's
	}

	private int[] getRandomLocation(BattleshipController battleshipController)
	{
		String s = String.valueOf(battleshipController.getSettingsFacade().getLength());
		int[] i = new int[3];
		i[0] = ThreadLocalRandom.current().nextInt(0, 9 + 1);
		i[1] = ThreadLocalRandom.current().nextInt(0, 9 + 1);
		i[2] = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		return i;
	}
}
