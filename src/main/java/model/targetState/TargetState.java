package model.targetState;

/**
 * @author: Louis Roebben
 */
public interface TargetState
{
	TargetState damage();

	TargetState sink();

	default String getName() {
		return this.getClass().getName();
	}

	default void processShipState()
	{

	}

}
