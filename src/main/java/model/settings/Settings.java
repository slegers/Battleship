package model.settings;


class Settings
{
	private static volatile Settings settings;
	private static boolean done = true;
	private int length, height;
	private Settings()
	{
	}

	public static synchronized Settings getSettings()
	{
		if (done)
		{
			done = false;
			settings = new Settings();
		}
		return settings;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public int getLength(){
		return length;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return height;
	}
}
