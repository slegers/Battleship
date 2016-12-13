package controller.ai;

import controller.BattleshipController;

class RandomStrategy implements AttackStrategy
{
	RandomStrategy() {
	}

	@Override
	public String getTarget(BattleshipController battleshipController) {
		return String.valueOf(battleshipController.getSettingsFacade().getLength());
	}
}
