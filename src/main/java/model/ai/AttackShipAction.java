package model.ai;

import controller.BattleshipController;
import model.Target;

import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * @author: Louis Roebben
 */
class AttackShipAction implements Action {
	private final AttackStrategy attackStrategy;
	ArrayList<Target> targets = new ArrayList<>();
	AttackShipAction(AttackStrategy attackStrategy)
	{
		this.attackStrategy = attackStrategy;
	}

	@Override
	public void doAction(BattleshipController battleshipController) {
		String target = attackStrategy.getTarget(battleshipController);
		while (getNewTarget(target)) target = attackStrategy.getTarget(battleshipController);
		try
		{
			battleshipController.getShipFacade("player").hit(target);
		} catch (NoSuchElementException ignored)
		{
		}
		//System.out.println("t: " + target);
		battleshipController.getShipFacade("player").notifyObservers(target);
	}

	private boolean getNewTarget(String target)
	{
		return targets.stream().anyMatch(obj -> obj.getName().equals(target));
	}
}
