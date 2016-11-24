package model.state;

public class HealtyState implements TargetState
{
	@Override
	public TargetState damage()
	{
		return new DamagedState();
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("healty can't sink");
	}

	@Override
	public TargetState missed() {
	}
}
