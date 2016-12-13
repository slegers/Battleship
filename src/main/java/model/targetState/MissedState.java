package model.targetState;

class MissedState implements TargetState
{
	MissedState() {
	}

	@Override
	public TargetState damage()
	{
		throw new IllegalStateException("missed state can't be damaged");
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("missed state can't be sunk");
	}
}
