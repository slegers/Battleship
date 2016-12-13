package controller.ai.attackstrategy;

import model.ShipFacade;
import model.Target;

public interface AttackStrategy
{
	Target getTarget(ShipFacade shipFacade);
}
