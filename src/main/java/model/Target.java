package model;

import model.TargetState.TargetState;

public class Target
{
	private String name;
	private Ship partOf;
	private Boolean hit = false;
	private TargetState state;

	public Target(String name, Ship partOf, TargetState targetState)
	{
		this.name = name;
		this.partOf = partOf;
		state = targetState;
	}

	public Target(String name)
	{
		this.name = name;

	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Ship getPartOf()
	{
		return partOf;
	}

	public void setPartOf(Ship partOf)
	{
		this.partOf = partOf;
	}

	public Boolean getHit()
	{
		return state.getClass().getName().equals("HitState");
	}

	public void setHit(Boolean hit)
	{
		if (hit)
			state.damage();
	}
}
