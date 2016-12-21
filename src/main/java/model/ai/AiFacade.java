package model.ai;

import controller.BattleshipController;

/**
 * @author: Louis Roebben
 */
public class AiFacade implements Action, AiSettings
{
	private final MainAi mainAi = new MainAi();

	void placingDone()
	{
		mainAi.placingDone();
	}

	@Override
	public void doAction(BattleshipController battleshipController) {
		mainAi.doAction(battleshipController);
	}

	@Override
	public void AiSettings(BattleshipController battleshipController)
	{
		mainAi.AiSettings(battleshipController);
	}
}
