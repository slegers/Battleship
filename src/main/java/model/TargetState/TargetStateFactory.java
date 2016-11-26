package model.TargetState;

/**
 * Created by louis on 26/11/2016.
 */
public interface TargetStateFactory
{
	static TargetState createEmptyState()
	{
		return new EmptyState();
	}

	static TargetState createHealtyState()
	{
		return new HealtyState();
	}
}
