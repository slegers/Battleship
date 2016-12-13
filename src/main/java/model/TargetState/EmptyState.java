package model.TargetState;

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
		throw new IllegalStateException("empty TargetState can't be damaged");
	}
}
