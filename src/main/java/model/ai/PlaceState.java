package model.ai;

/**
 * @author: Louis Roebben
 */
class PlaceState implements AiState
{
	PlaceState()
	{
	}

	@Override
	public Action getNextAction()
	{
		return new PlaceShipAction();
	}
}
