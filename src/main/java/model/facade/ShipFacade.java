package model.facade;

import model.Ship;
import model.ShipRepo;
import model.ShipRepoInterface;
import model.Target;
import model.type.ShipType;

import java.util.List;

public class ShipFacade implements ShipRepoInterface
{
	ShipRepo shipRepo = new ShipRepo();

	@Override
	public Ship getShip(String place)
	{
		return null;
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
