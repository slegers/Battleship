package model;

import model.type.ShipType;

import java.util.ArrayList;

abstract public class Ship implements hitable
{
	private ArrayList<Target> targets = new ArrayList<>();
	private ShipType type;

	public Ship(ArrayList<Target> targets, ShipType shipType)
	{
		type = shipType;
		this.targets = targets;
	}

	public ArrayList<Target> getTargets()
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
}
