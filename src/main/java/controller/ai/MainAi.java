package controller.ai;

import controller.BattleshipController;

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
