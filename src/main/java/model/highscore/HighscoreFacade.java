package model.highscore;

import java.util.List;
import java.util.Map;

public class HighscoreFacade implements HighscoreRepoInterface
{
	private HighscoreRepo highscoreRepo = HighscoreRepo.createHighscoreRepo();

	@Override
	public List<String> getValues()
	{
		return highscoreRepo.getValues();
	}

	@Override
	public void setValues(List<String> values)
	{
		highscoreRepo.setValues(values);
	}

	@Override
	public boolean addPossibleHighscore(String name, Integer count)
	{
		return highscoreRepo.addPossibleHighscore(name, count);
	}

	@Override
	public Map<String, Integer> getHighscores()
	{
		return highscoreRepo.getHighscores();
	}
}
