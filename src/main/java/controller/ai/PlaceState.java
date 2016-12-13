package controller.ai;

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
