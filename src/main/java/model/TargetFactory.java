package model;


import model.targetState.TargetState;
import model.targetState.TargetStateFactory;

/**
 * @author: Louis Roebben
 */
public interface TargetFactory
{
	@Deprecated
	static Target ceateTarget(String place, TargetState targetState)
	{
		return new Target(place, targetState);
	}

	static Target createForbiddenTarget(String place, Ship ship)
	{
		return new Target(place, ship, TargetStateFactory.createForbiddenState());
	}

	static Target createTarget(String place, Ship ship)
	{
		return new Target(place, ship, TargetStateFactory.createHealtyState());
	}
}
