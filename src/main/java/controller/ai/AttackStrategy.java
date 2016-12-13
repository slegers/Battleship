package controller.ai;

import controller.BattleshipController;

interface AttackStrategy
{
	String getTarget(BattleshipController battleshipController);
}
