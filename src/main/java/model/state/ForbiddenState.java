package model.state;

public class ForbiddenState implements TargetState
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
