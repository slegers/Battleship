package model.settings;

import model.type.ShipType;

public class SettingsFacade
{

	public int getLength()
	{
		return Settings.getSettings().getLength();
	}

	public void setLength(int length) {

		Settings.getSettings().setLength(length);
	}

    public int getHeight()
    {
        return Settings.getSettings().getHeight();
    }

	public void setHeight(int height) {
		Settings.getSettings().setHeight(height);
	}

    public int getMaxAmount(ShipType shipType)
	{
		return shipType.getMaxShips();
	}

	public void setAmount(ShipType shipType, int amount)
	{
		shipType.setMaxShips(amount);
	}

    public String getNamePlayer1(){
        return Settings.getSettings().getNamePlayer1();
    }

	public void setNamePlayer1(String name) {
		Settings.getSettings().setNamePlayer1(name);
	}

    public String getNamePlayer2(){
        return Settings.getSettings().getNamePlayer2();
    }

	public void setNamePlayer2(String name) {
		Settings.getSettings().setNamePlayer2(name);
	}

    public void setGameIsStarted(){
        Settings.getSettings().setGameIsStarted();
    }
    public boolean getGameIsStarted(){
        return Settings.getSettings().getGameIsStarted();
    }

    public String getPlaceStrategy(){
        return Settings.getSettings().getPlaceStrategy();
    }

	public void setPlaceStrategy(String strategy) {
		Settings.getSettings().setPlaceStrategy(strategy);
	}

    public String getAttackStrategy(){
        return Settings.getSettings().getAttackStrategy();
    }

	public void setAttackStrategy(String strategy) {
		Settings.getSettings().setAttackStrategy(strategy);
	}
}
