package model;


import model.TargetState.TargetState;
import model.TargetState.TargetStateFactory;

/**
 * @author: Louis Roebben
 */
public interface TargetFactory
{
	static Target ceateTarget(String place, TargetState targetState)
	{
		return new Target(place, targetState);
	}

	static Target createTarget(String place, Ship ship)
	{
		return new Target(place, ship, TargetStateFactory.createHealtyState());
	}
}
