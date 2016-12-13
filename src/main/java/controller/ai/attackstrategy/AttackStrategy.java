package controller.ai.attackstrategy;

import controller.BattleshipController;

public interface AttackStrategy
{
	String getTarget(BattleshipController battleshipController);
}
