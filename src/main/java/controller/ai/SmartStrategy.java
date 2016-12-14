package controller.ai;

import controller.BattleshipController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author: Louis Roebben
 */
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
