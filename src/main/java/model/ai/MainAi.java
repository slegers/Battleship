package model.ai;

import controller.BattleshipController;

/**
 * @author: Louis Roebben
 */
class MainAi implements Action
{
	private AiState aiState;

	public MainAi() {
		this.aiState = AiStateFactory.createPlaceState();

	}

	void placingDone() {
		this.aiState = AiStateFactory.createAttackState();
	}
	@Override
	public void doAction(BattleshipController battleshipController) {
		aiState.getNextAction().doAction(battleshipController);
	}
}
