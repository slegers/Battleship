package model.TargetState;

public interface TargetState
{
	TargetState damage();

	TargetState sink();

	TargetState placeShip();

	TargetState missed();

}
