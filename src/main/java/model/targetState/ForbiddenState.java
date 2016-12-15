package model.TargetState;

/**
 * @author: Louis Roebben
 */
class ForbiddenState implements TargetState
{
	ForbiddenState()
	{
	}

	@Override
	public TargetState damage()
	{
		throw new IllegalStateException("Forbidden targetState can't be damaged");
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("empty targetState can't be damaged");
	}
}
