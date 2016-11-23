package model.settings;


class Settings
{
	private static Settings settings;
	private static boolean done = true;

	private Settings()
	{
	}

	public Settings createSettings()
	{
		if (done)
		{
			done = false;
			settings = new Settings();
		}
		return settings;
	}
}
