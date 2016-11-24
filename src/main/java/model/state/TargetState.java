package model.state;

public interface TargetState
{
	TargetState damage();

	TargetState sink();

	void missed();

}
