package model.TargetState;

public class HealtyState implements TargetState
{
	public HealtyState()
	{
	}

	@Override
	public TargetState damage()
	{
		return new hitState();
	}

	@Override
	public TargetState sink()
	{
		throw new IllegalStateException("healty can't sink");
	}


    public TargetState placeShip() {
        return null;
    }

	@Override
<<<<<<< HEAD:src/main/java/model/state/HealtyState.java
	public TargetState missed() {return null;
=======
	public TargetState missed() {
		throw new IllegalStateException("healty TargetState can't be missed");
>>>>>>> 2119ca2bc0cbdcdc25e2fb54e21a567060185b26:src/main/java/model/TargetState/HealtyState.java
	}
}
