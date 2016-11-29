package model.TargetState;

class HealtyState implements TargetState
{
	HealtyState()
	{
	}

	@Override
	public TargetState damage()
	{
		return new hitState();
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("healty can't sink");
	}


    public TargetState placeShip() {
        return null;
    }

	public TargetState missed() {
		throw new IllegalStateException("healty TargetState can't be missed");

	}
}
