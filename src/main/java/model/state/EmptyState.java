package model.state;

import model.Target;

public class EmptyState implements TargetState
{
	@Override
	public TargetState damage()
	{
		return null;
	}

	@Override
	public TargetState sink()
	{
		return null;
	}

	@Override
	public TargetState missed() {return null; }
}
