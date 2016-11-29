package model.TargetState;

class HitState implements TargetState
{
	HitState()
	{
	}

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
}
