package model.targetState;

class EmptyState implements TargetState
{
	EmptyState()
	{
	}

	@Override
	public TargetState damage()
	{
		return new MissedState();
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("empty targetState can't be damaged");
	}
}
