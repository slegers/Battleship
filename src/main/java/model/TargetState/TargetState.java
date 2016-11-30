package model.TargetState;

public interface TargetState
{
	TargetState damage();

	TargetState sink();

	default void processShipState()
	{

	}

}
