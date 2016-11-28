package model.state;


import model.Target;
import model.TargetState.HealtyState;
import model.TargetState.TargetState;

public class EmptyState implements TargetState
{
	@Override
	public TargetState damage() {
		return null;
	}

	@Override
	public TargetState sink()
	{
        throw new IllegalStateException("You can't sink a target that is empty.");
	}
	@Override
	public TargetState missed() {return null; }

    @Override
    public TargetState placeShip() {
        return new HealtyState();
    }
}
