package model.ai;



/**
 * @author: Louis Roebben
 */
class AttackState implements AiState
{
	private final AttackStrategy attackStrategy;
	private final AttackShipAction attackShipAction;
	AttackState(AttackStrategy attackStrategy)
	{
		this.attackStrategy = attackStrategy;
		this.attackShipAction = new AttackShipAction(attackStrategy);
	}

	@Override
	public Action getNextAction()
	{
		return attackShipAction;
	}
}
