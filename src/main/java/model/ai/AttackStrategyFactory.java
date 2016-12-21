package model.ai;

import model.settings.SettingsFacade;

/**
 * @author: Louis Roebben
 */
interface AttackStrategyFactory {

	static AttackStrategy createStrategy(SettingsFacade settingsFacade)
	{
		String attackStrategy = settingsFacade.getAttackStrategy();
		try
		{
			Class attackStrategyName = Class.forName("model.ai." + attackStrategy + "Strategy");
			return (AttackStrategy) attackStrategyName.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException ignored)
		{
		}
		return createRandomStrategy();
	}

	@Deprecated
	static AttackStrategy createRandomStrategy() {
		return new RandomStrategy();
	}
}
