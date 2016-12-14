package controller.ai;

import controller.BattleshipController;

/**
 * @author: Louis Roebben
 */
interface AttackStrategy
{
	String getTarget(BattleshipController battleshipController);
}
