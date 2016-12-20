package model;


import model.targetState.TargetState;
import model.targetState.TargetStateFactory;

/**
 * @author: Louis Roebben
 */
public interface TargetFactory
{

	static Target ceateTarget(int place, TargetState targetState)
	{
		return new Target(place, targetState);
	}

	static Target createForbiddenTarget(int place, Ship ship)
	{
		return new Target(place, ship, TargetStateFactory.createForbiddenState());
	}

	static Target createTarget(int place, Ship ship)
	{
		return new Target(place, ship, TargetStateFactory.createHealtyState());
	}
}
