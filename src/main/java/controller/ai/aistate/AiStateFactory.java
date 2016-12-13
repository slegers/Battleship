package controller.ai.aistate;

import controller.ai.attackstrategy.AttackStrategy;
import controller.ai.attackstrategy.AttackStrategyFactory;

/**
 * Created by covert on 13/12/16.
 */
public interface AiStateFactory {
	static AiState createAttackState() {
		return new AttackState(AttackStrategyFactory.createRandomStrategy());
	}

	static AiState createAttackState(AttackStrategy attackStrategy) {
		return new AttackState(attackStrategy);
	}

	static AiState createPlaceState() {
		return new PlaceState();
	}
}
