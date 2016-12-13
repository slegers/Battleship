package controller.ai.attackstrategy;

import controller.BattleshipController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SmartStrategy implements AttackStrategy
{
	SmartStrategy() {
	}

	@Override
	public String getTarget(BattleshipController battleshipController)
	{
		throw new NotImplementedException();
	}
}
