package model.ai;

/**
 * @author: Louis Roebben
 */
interface AttackStrategyFactory {
	static AttackStrategy createRandomStrategy() {
		return new RandomStrategy();
	}
}
