package model.TargetState;

import model.TargetState.TargetState;

/**
 * @author: Louis Roebben
 */
public interface TargetStateFactory
{
	static TargetState createEmptyState()
	{
		return new EmptyState();
	}

	static TargetState createHealtyState()
	{
		return new HealtyState();
	}

	static TargetState createForbiddenState()
	{
		return new ForbiddenState();
	}
}
