package model;

import model.type.ShipType;

import java.util.ArrayList;
import java.util.List;

public class ShipRepo implements ShipRepoInterface
{
	ArrayList<Ship> ships = new ArrayList<>();

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
		//TODO defensive
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
}
