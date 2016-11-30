package model;

import model.type.ShipType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ShipRepo implements ShipRepoInterface
{
	private ArrayList<Ship> ships = new ArrayList<>();
	private HashMap<ShipType, Integer> regesterdShips = new HashMap<>();

	ShipRepo() {
		//init regesterdShips
		for (ShipType shipType : ShipType.values())
		{
			regesterdShips.put(shipType, 0);
		}
	}

	@Override
	public Ship getShip(String targetName)
	{
		return ships.parallelStream().filter(obj -> obj.inhabitsTarget(targetName)).findAny().get();
	}

	@Override
	public Ship getShip(Target place)
	{
		return this.getShip(place.getName());
	}

	@Override
	public ShipType getShipType(String place)
	{
		return this.getShip(place).getType();
	}

	@Override
	public ShipType getShipType(Target place)
	{
		return this.getShipType(place.getName());
	}

	@Override
	public void setShip(Ship ship)
	{
		Integer amountOfType = regesterdShips.get(ship.getType());
		if (amountOfType >= ship.getType().getMaxShips())
			throw new IllegalStateException("te veel schepen van type" + ShipType.Aircraftcarrier.name());
		if (ship.getType().getSize() != ship.getTargets().size())
			throw new IllegalStateException("schip heeft foute aantal targets");
		ships.add(ship);
	}

	@Override
	public List<Ship> getAllShips()
	{
		return ships;
	}

	@Override
	public Boolean hit(String place)
	{
		return this.getShip(place).getHit(place);
	}

	@Override
	public Boolean hit(Target place)
	{
		return this.hit(place.getName());
	}

	@Override
	public Map<ShipType, Integer> getAvailableShipCount() {
		Map<ShipType, Integer> availableCount = new HashMap<>();
		for (Map.Entry<ShipType, Integer> varNext : regesterdShips.entrySet()) {
			availableCount.put(varNext.getKey(), varNext.getKey().getMaxShips() - varNext.getValue());
		}
		return availableCount;
	}
}
