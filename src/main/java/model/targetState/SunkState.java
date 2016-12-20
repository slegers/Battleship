package model.targetState;

/**
 * @author: Louis Roebben
 */
class SunkState implements TargetState
{
	SunkState()
	{

	}

	@Override
	public TargetState damage()
	{
		throw new IllegalStateException("sunkstate can't be damaged");
	}

	@Override
	public TargetState sink()
	{
		return this;
	}
}
