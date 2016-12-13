package controller.ai.aistate;

import controller.ai.Action;
import controller.ai.actions.AttackShipAction;
import controller.ai.attackstrategy.AttackStrategy;

public class AttackState implements AiState
{
	private final AttackStrategy attackStrategy;

	AttackState(AttackStrategy attackStrategy)
	{
		this.attackStrategy = attackStrategy;
	}

	@Override
	public Action getNextAction()
	{
		return new AttackShipAction(attackStrategy);
	}
}
