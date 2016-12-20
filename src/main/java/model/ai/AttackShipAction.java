package model.ai;

import controller.BattleshipController;

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
		battleshipController.getShipFacade("player1").hit(attackStrategy.getTarget(battleshipController));
	}
}
