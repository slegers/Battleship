package controller.ai;

/**
 * Created by covert on 13/12/16.
 */
interface AttackStrategyFactory {
	static AttackStrategy createRandomStrategy() {
		return new RandomStrategy();
	}
}
