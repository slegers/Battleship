package model.targetState;

/**
 * @author: Louis Roebben
 */
class DamagedState implements TargetState
{
	DamagedState()
	{
	}

	@Override
	public TargetState damage()
	{
		return this;
	}

	@Override
	public TargetState sink()
	{
		return new SunkState();
	}
}
