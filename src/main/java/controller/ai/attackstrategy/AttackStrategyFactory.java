package controller.ai.attackstrategy;

/**
 * Created by covert on 13/12/16.
 */
public interface AttackStrategyFactory {
	static AttackStrategy createRandomStrategy() {
		return new RandomStrategy();
	}
}
