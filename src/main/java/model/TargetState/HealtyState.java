package model.TargetState;

class HealtyState implements TargetState
{
	HealtyState()
	{
	}

	@Override
	public TargetState damage()
	{
		return new HitState();
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("Healty can't imediatly sink");
	}
}
