package model.factory;

import model.Ship;
import model.ShipFacade;
import model.Target;
import model.type.ShipType;

import java.util.List;

public interface ShipFactory
{
	static Ship createAircraftcarrier(List<Target> targets, ShipFacade shipFacade)
	{
		Ship ship = new Ship(targets, ShipType.Aircraftcarrier);
		shipFacade.setShip(ship);
		return ship;
	}

	static Ship createBattleShip(List<Target> targets, ShipFacade shipFacade)
	{
		Ship ship = new Ship(targets, ShipType.BattleShip);
		shipFacade.setShip(ship);
		return ship;
	}

	static Ship createCruiser(List<Target> targets, ShipFacade shipFacade)
	{
		Ship ship = new Ship(targets, ShipType.Cruiser);
		shipFacade.setShip(ship);
		return ship;
	}

	static Ship createDestroyer(List<Target> targets, ShipFacade shipFacade)
	{
		Ship ship = new Ship(targets, ShipType.Destroyer);
		shipFacade.setShip(ship);
		return ship;
	}

	static Ship createSubmarine(List<Target> targets, ShipFacade shipFacade)
	{
		Ship ship = new Ship(targets, ShipType.Submarine);
		shipFacade.setShip(ship);
		return ship;
	}
}
