package model.ai;

import controller.BattleshipController;
import model.ShipFacade;

import java.util.NoSuchElementException;

/**
 * @author: Louis Roebben
 */
class AttackShipAction implements Action {
	private final AttackStrategy attackStrategy;

	AttackShipAction(AttackStrategy attackStrategy)
	{
		this.attackStrategy = attackStrategy;
	}

	@Override
	public void doAction(BattleshipController battleshipController) {
		String target = attackStrategy.getTarget(battleshipController);
		try
		{
			battleshipController.getShipFacade("player").hit(target);

		} catch (NoSuchElementException ignored)
		{
		}
		battleshipController.getShipFacade("player").notifyObservers();
	}
}
