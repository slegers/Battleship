package model;

import model.type.ShipType;

import java.util.List;
import java.util.Map;

/**
 * @author: Louis Roebben
 */
interface ShipRepoInterface
{
	Ship getShip(String place);

	Ship getShip(Target place);

	ShipType getShipType(String place);

	ShipType getShipType(Target place);

	void setShip(Ship ship);

	List<Ship> getAllShips();

	Boolean hit(String place);

	Boolean hit(Target place);

	Map<ShipType, Integer> getAvailableShipCount();

}
