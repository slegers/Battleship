package model.targetState;

/**
 * @author: Louis Roebben
 */
public interface TargetState
{
	TargetState damage();

	TargetState sink();

	default void processShipState()
	{

	}

}
