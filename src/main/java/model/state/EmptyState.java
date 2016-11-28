package model.state;

<<<<<<< HEAD
import model.Target;
=======
import model.TargetState.HealtyState;
import model.TargetState.TargetState;
>>>>>>> 2119ca2bc0cbdcdc25e2fb54e21a567060185b26

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

<<<<<<< HEAD
	@Override
	public TargetState missed() {return null; }
=======
    @Override
    public TargetState placeShip() {
        return new HealtyState();
    }

    @Override
    public TargetState missed() {
        return null;
    }

>>>>>>> 2119ca2bc0cbdcdc25e2fb54e21a567060185b26
}
