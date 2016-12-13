package model.targetState;

public interface TargetState
{
	TargetState damage();

	TargetState sink();

	default void processShipState()
	{

	}

}
