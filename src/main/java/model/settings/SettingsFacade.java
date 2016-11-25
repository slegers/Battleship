package model.settings;

import model.type.ShipType;

public class SettingsFacade
{

	public void setLength(int length){
        Settings.getSettings().setLength(length);
    }

	public int getLength()
	{
		return Settings.getSettings().getLength();
	}

    public void setHeight(int height){
        Settings.getSettings().setLength(height);
    }

    public int getHeight()
    {
        return Settings.getSettings().getHeight();
    }


    public int getAmount(ShipType shipType)
	{
		return shipType.getMaxShips();
	}

	public void setAmount(ShipType shipType, int amount)
	{
		shipType.setMaxShips(amount);
	}

}
