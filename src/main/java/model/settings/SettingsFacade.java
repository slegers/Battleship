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
        Settings.getSettings().setHeight(height);
    }

    public int getHeight()
    {
        return Settings.getSettings().getHeight();
    }


    public int getMaxAmount(ShipType shipType)
	{
		return shipType.getMaxShips();
	}

	public void setAmount(ShipType shipType, int amount)
	{
		shipType.setMaxShips(amount);
	}

	public void setNamePlayer1(String name){
		Settings.getSettings().setNamePlayer1(name);
	}
    public void setNamePlayer2(String name){
        Settings.getSettings().setNamePlayer2(name);
    }
    public String getNamePlayer1(){
        return Settings.getSettings().getNamePlayer1();
    }
    public String getNamePlayer2(){
        return Settings.getSettings().getNamePlayer2();
    }
}
