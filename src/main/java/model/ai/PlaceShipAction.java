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

					if (!isValidLocation(location, varShipType.getSize(), location[2], battleshipController))
					{
						i--;
						continue shipBreakLoop;
					}
//create targets
					for (int count = -1; count <= varShipType.getSize(); count++)
					{
						int iup = (location[2] == 0) ? 0 : 1;
						int iside = (location[2] == 1) ? 0 : 1;
						int currentX = location[0] + count * iside;
						int currentY = location[1] + count * iup;
						String sideA = String.valueOf(currentX + 1) + currentY;
						String sideB = String.valueOf(currentX - 1) + currentY;
						if (Integer.parseInt(sideA) >= 0) targets.add(TargetFactory.createForbiddenTarget(sideA));
						if (Integer.parseInt(sideB) >= 0) targets.add(TargetFactory.createForbiddenTarget(sideB));
						if (count < 0)
						{
							targets.add(TargetFactory.createForbiddenTarget(String.valueOf(currentX) + currentY));
						} else if (count == varShipType.getSize())
						{
							targets.add(TargetFactory.createForbiddenTarget(String.valueOf(currentX) + currentY));
						} else {
							targets.add(TargetFactory.createTarget(String.valueOf(currentX) + currentY));
						}
					}
					assert targets.stream().noneMatch(obj -> obj.getName().contains("-"));
					//System.out.println("adding");
					Method createShipMethod = ShipFactory.class.getMethod("create" + varShipType.name(), List.class, ShipFacade.class);
					createShipMethod.invoke(new ShipFactory() {}, targets, aiShipsFacade);
					//ship.setTargets(targets);
					//aiShipsFacade.setShip(ship);

				} catch (IllegalAccessException e)
				{
					e.printStackTrace();
				} catch (InvocationTargetException e)
				{
					e.getTargetException().printStackTrace();
				} catch (NoSuchMethodException ex) {
					System.out.println(varShipType.name());
				}
				iCount++;
				//System.out.println("placing done " + iCount);
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

	private boolean isValidLocation(int[] location, int size, int direction, BattleshipController battleshipController)
	{
		return this.isValidLocation(new String[]{String.valueOf(location[0]), String.valueOf(location[1])}, size, direction, battleshipController);
	}

	private int[] getRandomLocation(BattleshipController battleshipController)
	{
		int[] i = new int[3];
		i[0] = ThreadLocalRandom.current().nextInt(0, battleshipController.getSettingsFacade().getLength() + 1);
		i[1] = ThreadLocalRandom.current().nextInt(0, battleshipController.getSettingsFacade().getLength() + 1);
		i[2] = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		return i;
	}

	private boolean isValidLocation(String[] place, int length, int direction, BattleshipController battleshipController)
	{
		ShipFacade aiShipsFacade = battleshipController.getShipFacade("ai");
		int iup = (direction == 0) ? 0 : 1;
		int iside = (direction == 1) ? 0 : 1;
		for (int i = 0; i <= length; i++)
		{
			if (checkLocation(place, battleshipController, aiShipsFacade, iup, iside, i)) return false;
		}
		return true;
	}

	private boolean checkLocation(String[] place, BattleshipController battleshipController, ShipFacade aiShipsFacade, int iup, int iside, int i)
	{
		int[] finalLocation = {Integer.parseInt(place[0]), Integer.parseInt(place[1])};
		int finalI = i;
		return aiShipsFacade.getAllShips().stream().anyMatch(obj -> obj.inhabitsTarget(String.valueOf(finalLocation[0] + finalI * iside) + (finalLocation[1] + finalI * iup))) || finalLocation[0] < 0 || finalLocation[0] + i * iside > battleshipController.getSettingsFacade().getLength() || finalLocation[1] < 0 || finalLocation[1] + i * iup > battleshipController.getSettingsFacade().getLength();
	}
}
