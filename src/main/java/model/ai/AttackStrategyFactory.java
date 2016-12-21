package model.ai;

import controller.BattleshipController;

/**
 * @author: Louis Roebben
 */
interface AttackStrategyFactory {

	static AttackStrategy createRandomStrategy() {
		return new RandomStrategy();
	}
}
