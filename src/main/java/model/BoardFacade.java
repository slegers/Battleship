package model;

import java.util.HashMap;

public class BoardFacade
{
	HashMap<String, ShipFacade> boardRepo = new HashMap<>();

	public ShipFacade getShipRepo(String id)
	{
		if (!boardRepo.containsKey(id))
		{
			boardRepo.put(id, new ShipFacade());
			return this.getShipRepo(id);
		}
		return boardRepo.get(id);
	}
}
