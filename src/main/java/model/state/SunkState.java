package model.state;

import model.TargetState.TargetState;

public class SunkState implements TargetState
{
	@Override
	public TargetState damage()
	{
		throw new IllegalStateException("sunken state can't go to damaged");
	}

	@Override
	public TargetState sink()
	{
		return null;
	}

    @Override
    public TargetState placeShip(){
        throw new IllegalStateException("You can't place a ship at on a sunken target.");
    }

    @Override
    public TargetState missed() {
        throw new IllegalStateException("You can't hit a target when it is already sunken.");
    }

}
