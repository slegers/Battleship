package model;

import model.TargetState.TargetStateFactory;

public interface TargetFactory
{
	static Target ceateTarget(String place)
	{
		return new Target(place);
	}

	static Target createTarget(String place, Ship ship)
	{
		return new Target(place, ship, TargetStateFactory.createHealtyState());
	}
}
