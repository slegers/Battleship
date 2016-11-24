package model.state;

public class EmptyState implements TargetState
{
	@Override
	public TargetState damage()
	{
		 throw new IllegalStateException("You can't damage a target that is empty.");
	}

	@Override
	public TargetState sink()
	{
        throw new IllegalStateException("You can't sink a target that is empty.");
	}

    @Override
    public TargetState placeShip() {
        return new HealtyState();
    }

    @Override
    public TargetState missed() {
        return null;
    }

}
