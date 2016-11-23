package model;

import java.util.ArrayList;

abstract public class Ship
{
	ArrayList<Target> targets = new ArrayList<>();

	public Ship(ArrayList<Target> targets)
	{
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
