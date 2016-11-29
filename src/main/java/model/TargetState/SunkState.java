package model.TargetState;

/**
 * Created by louis on 26/11/2016.
 */
class SunkState implements TargetState
{
	SunkState()
	{

	}

	@Override
	public TargetState damage()
	{
		throw new IllegalStateException("sunkstate can't be damaged");
	}

	@Override
	public TargetState sink()
	{
		return this;
	}
}
