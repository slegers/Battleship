package model.ai;

import controller.BattleshipController;
import model.observer.Observer;
import model.settings.SettingsFacade;

/**
 * @author: Louis Roebben
 */
class MainAi implements Action, AiSettings
{
	private AiState aiState;
	private SettingsFacade settingsFacade;
	private BattleshipController battleshipController;

	public MainAi()
	{
		this.aiState = AiStateFactory.createPlaceState();

	}

	void placingDone()
	{
		this.aiState = AiStateFactory.createAttackState(settingsFacade);
	}

	@Override
	public void doAction(BattleshipController battleshipController)
	{

		aiState.getNextAction().doAction(battleshipController);
	}

	@Override
	public void AiSettings(BattleshipController battleshipController)
	{
		this.settingsFacade = battleshipController.getSettingsFacade();
	}
}
