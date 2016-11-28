package model.TargetState;

class hitState implements TargetState
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
	public TargetState placeShip() {
		return null;
	}

	@Override
	public TargetState missed() {
		return null;
	}
}
