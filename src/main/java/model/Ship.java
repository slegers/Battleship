package model;

import model.type.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Ship implements hitable
{
	private List<Target> targets = new ArrayList<>();
	private ShipType type;

	public Ship(List<Target> targets, ShipType shipType)
	{
		type = shipType;
		this.targets = targets;
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

	public boolean inhabitsTarget(Target target)
	{
		return this.inhabitsTarget(target.getName());
	}

	public ShipType getType()
	{
		return type;
	}

	public boolean getHit(String place)
	{
		final Target target = targets.parallelStream().filter(obj -> obj.getName().equals(place)).findAny().get();
		return target.getHit();
	}
}
