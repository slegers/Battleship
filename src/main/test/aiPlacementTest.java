import controller.BattleshipController;
import model.ShipFacade;
import model.ai.AiFacade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by louis on 24/12/2016.
 */
public class aiPlacementTest
{
	@Test
	public void testPlacement()
	{
		int maxShips = 5;
		BattleshipController battleshipController = new BattleshipController();
		AiFacade aiFacade = new AiFacade();
		aiFacade.doAction(battleshipController);
		ShipFacade ai = battleshipController.getShipFacade("ai");
		assertTrue(ai.getAllShips().size() == 5);

	}
}
