package model;

public class Target
{
	private String name;
	private Ship partOf;
	private Boolean hit;

	public Target(String name, Ship partOf, Boolean hit)
	{
		this.name = name;
		this.partOf = partOf;
		this.hit = hit;
	}

	public Target()
	{
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
		return hit;
	}

	public void setHit(Boolean hit)
	{
		this.hit = hit;
	}
}
