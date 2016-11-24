package model.state;

public interface TargetState
{
	TargetState damage();

	TargetState sink();

	TargetState placeShip();

	TargetState missed();

}
