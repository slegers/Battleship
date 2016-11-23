package model;

import java.util.List;

public interface ShipRepoInterface
{
	Ship getShip(String place);

	List<Ship> getAllShips();
}
