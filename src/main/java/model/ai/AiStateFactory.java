package model.ai;


import model.settings.SettingsFacade;

/**
 * @author: Louis Roebben
 */
interface AiStateFactory {
	static AiState createAttackState(SettingsFacade settingsFacade)
	{
		return new AttackState(AttackStrategyFactory.createStrategy(settingsFacade));
	}

	static AiState createAttackState(AttackStrategy attackStrategy) {
		return new AttackState(attackStrategy);
	}

	static AiState createPlaceState() {
		return new PlaceState();
	}
}
