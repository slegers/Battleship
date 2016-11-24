package model.state;

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
	public void missed() {
	}
}
