package model;

import model.type.ShipType;

import java.util.List;
import java.util.Map;

public class ShipFacade implements ShipRepoInterface
{
	private final ShipRepo shipRepo = new ShipRepo();

	ShipFacade()
	{
	}

	@Override
	public Ship getShip(String place)
	{
		return shipRepo.getShip(place);
	}

	@Override
	public Ship getShip(Target place)
	{
		return shipRepo.getShip(place);
	}

	@Override
	public ShipType getShipType(String place)
	{
		return shipRepo.getShipType(place);
	}

	@Override
	public ShipType getShipType(Target place)
	{
		return shipRepo.getShipType(place);
	}

	@Override
	public void setShip(Ship ship)
	{
		shipRepo.setShip(ship);
	}

	@Override
	public List<Ship> getAllShips()
	{
		return shipRepo.getAllShips();
	}

	@Override
	public Boolean hit(String place)
	{
		return shipRepo.hit(place);
	}

	@Override
	public Boolean hit(Target place)
	{
		return shipRepo.hit(place);
	}

	@Override
	public Map<ShipType, Integer> getAvailableShipCount() {
		return shipRepo.getAvailableShipCount();
	}
}
