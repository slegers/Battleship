package model.ShipState;

/**
 * Created by louis on 26/11/2016.
 */
public interface ShipState
{
	ShipState damage();

	ShipState sink();

	ShipState missed();
}
