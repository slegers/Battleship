package controller.ai;

import controller.BattleshipController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class SmartStrategy implements AttackStrategy
{
	SmartStrategy() {
	}

	@Override
	public String getTarget(BattleshipController battleshipController)
	{
		throw new NotImplementedException();
	}
}
