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
		throw new IllegalStateException("sunkstate is already sunk");
	}

	@Override
	public TargetState missed()
	{
		throw new IllegalStateException("sunkstate can't be missed");
	}
}
