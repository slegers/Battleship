package model.ai;

/**
 * @author: Louis Roebben
 */
interface AiStateFactory {
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
