package model;

import model.observer.Observer;
import model.type.ShipType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Louis Roebben
 */
class ShipRepo implements ShipRepoInterface
{
	private final static int iMaxShips = 5; //TODO FROM SETTINGS
	private final ArrayList<Ship> ships = new ArrayList<>();
	private final HashMap<ShipType, Integer> regesterdShips = new HashMap<>();
	private ArrayList<Observer> observersList = new ArrayList<>();
	private int misses;
	ShipRepo() {
		//init regesterdShips
		for (ShipType shipType : ShipType.values())
		{
			regesterdShips.put(shipType, 0);
		}
		misses = 0;
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
		if (regesterdShips.values().stream().mapToLong(Integer::longValue).sum() > iMaxShips)
			throw new IllegalStateException("te veel schepen in algemeen");
		Integer amountOfType = regesterdShips.get(ship.getType());
		if (amountOfType > ship.getType().getMaxShips())
			throw new IllegalStateException("te veel schepen van type" + ShipType.Aircraftcarrier.name());
		if (ship.getType().getSize() != ship.getTargets().stream().filter(obj -> obj.getState().getName().contains("HealtyState")).count())
			throw new IllegalStateException("schip heeft foute aantal targets, " + ship.getType().getSize() + " " + ship.getTargets().stream().filter(obj -> obj.getState().getName().equals("HealtyState")).count());
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
		return this.getShip(place).getsHit(place);
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
	public void missed(){
		misses = misses + 1;
	}
	public int getMisses(){
		return misses;
	}

	@Override
	public List<Observer> getObservers() {
		return null;
	}

	@Override
	public void registerObserver(Observer o) {
		observersList.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observersList.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observersList){
			observer.update();
		}
	}

	public ArrayList<Observer> getObserversList() {
		return observersList;
	}

	public void setObserversList(ArrayList<Observer> observersList) {
		this.observersList = observersList;
	}
}
