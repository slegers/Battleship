package model.state;

public class DamagedState implements TargetState
{

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

	@Override
	public TargetState missed() {
		return null;
	}
}
