package controller.ai;

/**
 * @author: Louis Roebben
 */
class AttackState implements AiState
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
