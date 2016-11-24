package model.state;

public class EmptyState implements TargetState
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
    public void missed() {

    }
}
