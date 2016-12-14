package model;


/**
 * @author: Louis Roebben
 */
public class Target
{
	private String name;
	private Ship partOf;
	private TargetState state;

	Target(String name, Ship partOf, TargetState targetState)
	{
		this.name = name;
		this.partOf = partOf;
		state = targetState;
	}

	@Deprecated
	public Target(String name)
	{
		this.name = name;

	}

	public Target(String name, TargetState targetState)
	{
		this.name = name;
		this.state = targetState;
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
		state = state.damage();
	}
}
