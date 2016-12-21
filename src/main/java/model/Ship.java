package model;

import model.type.ShipType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Louis Roebben
 */
public class Ship implements hitable
{
	private final ShipType type;
	private List<Target> targets = new ArrayList<>();

	public Ship(List<Target> targets, ShipType shipType)
	{
		type = shipType;
		this.targets = targets;
		for(Target t : targets){
			t.setPartOf(this);
		}
	}

	public boolean isShipSunk() {
		if (targets.stream().filter(obj ->
				!obj.getState().getName().contains("Forbidden")).noneMatch(obj ->
				obj.getState().getName().contains("Healty"))) {
			targets.forEach(obj -> obj.getState().sink());
			return true;
		}
		return false;
	}
	public List<Target> getTargets()
	{
		return targets;
	}

	public void setTargets(ArrayList<Target> targets)
	{
		this.targets = targets;
	}

	public boolean inhabitsTarget(String target)
	{
		return targets.parallelStream().anyMatch(obj -> obj.getName().equals(target));
	}

	private Target getTarget(String place)
	{
		return targets.parallelStream().filter(obj -> obj.getName().equals(place)).findAny().get();
	}

	private Target getTarget(Target target)
	{
		return getTarget(target.getName());
	}

	public boolean inhabitsTarget(Target target)
	{
		return this.inhabitsTarget(target.getName());
	}

	public ShipType getType()
	{
		return type;
	}

	public boolean getsHit(String place)
	{
		final Target target = targets.parallelStream().filter(obj -> obj.getName().equals(place)).findAny().get();
		return target.getHit();
	}

	@Override
	public boolean getsHit(Target place)
	{
		return this.getsHit(place.getName());
	}
}
