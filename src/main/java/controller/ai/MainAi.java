package controller.ai;

import controller.BattleshipController;
import controller.ai.aistate.AiState;
import controller.ai.aistate.AiStateFactory;

class MainAi implements Action
{
	private final AiState aiState;

	public MainAi() {
		this.aiState = AiStateFactory.createPlaceState();
	}

	@Override
	public void doAction(BattleshipController battleshipController) {
		aiState.getNextAction().doAction(battleshipController);
	}
}
