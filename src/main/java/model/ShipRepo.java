package model;

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
	public List<Ship> getAllShips()
	{
		return null;
	}
}
