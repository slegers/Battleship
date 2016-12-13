package controller.ai;

/**
 * Created by covert on 13/12/16.
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
