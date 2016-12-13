package controller.ai.actions;

import controller.BattleshipController;
import controller.ai.Action;
import controller.ai.attackstrategy.AttackStrategy;

/**
 * Created by covert on 13/12/16.
 */
public class AttackShipAction implements Action {
	private final AttackStrategy attackStrategy;

	public AttackShipAction(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}

	@Override
	public void doAction(BattleshipController battleshipController) {
		battleshipController.getShipFacade("player1").hit(attackStrategy.getTarget(battleshipController));
	}
}
