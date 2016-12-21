package model.highscore;

import java.util.List;
import java.util.Map;

/**
 * @author: Louis Roebben
 */
public class HighscoreFacade implements HighscoreRepoInterface
{
	private final HighscoreRepo highscoreRepo = HighscoreRepo.createHighscoreRepo();

	public List<String> getValues()
	{
		return highscoreRepo.getValues();
	}

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
