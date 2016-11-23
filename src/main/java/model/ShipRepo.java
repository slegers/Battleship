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
		return null;
	}

	@Override
	public ShipType getShipType(String place)
	{
		return null;
	}

	@Override
	public ShipType getShipType(Target place)
	{
		return null;
	}

	@Override
	public void setShip(Ship ship)
	{

	}

	@Override
	public List<Ship> getAllShips()
	{
		return null;
	}

	@Override
	public Boolean hit(String place)
	{
		return null;
	}

	@Override
	public Boolean hit(Target place)
	{
		return null;
	}
}
