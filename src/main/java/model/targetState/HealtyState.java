package model.TargetState;

/**
 * @author: Louis Roebben
 */
class HealtyState implements TargetState
{
	HealtyState()
	{
	}

	@Override
	public TargetState damage()
	{
		return new DamagedState();
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("Healty can't imediatly sink");
	}
}
