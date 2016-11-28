package model.state;

import model.TargetState.TargetState;

public class ForbiddenState implements TargetState
{
	@Override
	public TargetState damage()
	{
		return null;
	}

	@Override
	public TargetState sink()
	{
		return null;
	}

	@Override
	public TargetState placeShip() {
		 throw new IllegalStateException("You can't place a ship at on this position target.");
	}

	@Override
	public TargetState missed() {
		return null;
	}

}
