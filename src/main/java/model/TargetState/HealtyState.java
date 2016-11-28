package model.TargetState;

public class HealtyState implements TargetState
{
	public HealtyState()
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
