package model.TargetState;

class ForbiddenState implements TargetState
{
	ForbiddenState()
	{
	}

	@Override
	public TargetState damage()
	{
		throw new IllegalStateException("Forbidden TargetState can't be damaged");
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("empty TargetState can't be damaged");
	}

	@Override
	public TargetState placeShip() {
		return null;
	}

	@Override
	public TargetState missed() {
		throw new IllegalStateException("empty TargetState can't be damaged");
	}
}
