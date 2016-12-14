package controller.ai;

import controller.BattleshipController;

/**
 * Created by covert on 13/12/16.
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
