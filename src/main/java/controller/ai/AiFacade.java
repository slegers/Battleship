package controller.ai;

import controller.BattleshipController;

/**
 * Created by covert on 13/12/16.
 */
public class AiFacade implements Action {
	private final MainAi mainAi = new MainAi();

	@Override
	public void doAction(BattleshipController battleshipController) {
		mainAi.doAction(battleshipController);
	}
}
