package model.targetState;

public class MissedState implements TargetState
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
}
