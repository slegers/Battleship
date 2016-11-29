package model.TargetState;

class EmptyState implements TargetState
{
	EmptyState()
	{
	}

	@Override
	public TargetState damage()
	{
		throw new IllegalStateException("empty TargetState can't be damaged");
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("empty TargetState can't be damaged");
	}
}
