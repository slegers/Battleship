package controller.ai;

import controller.BattleshipController;

import java.util.Random;

class RandomStrategy implements AttackStrategy
{
	RandomStrategy() {
	}

	@Override
	public String getTarget(BattleshipController battleshipController) {
		Random random = new Random();
		String s = String.valueOf(battleshipController.getSettingsFacade().getLength());
		String i = String.valueOf(random.nextInt(Integer.parseInt(s)));
		i += String.valueOf(random.nextInt(Integer.parseInt(s)));
		return i;
	}
}
