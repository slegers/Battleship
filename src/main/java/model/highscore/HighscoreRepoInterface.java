package model.highscore;

import java.util.Map;

/**
 * @author: Louis Roebben
 */
public interface HighscoreRepoInterface
{
	boolean addPossibleHighscore(String name, Integer count);
	Map<String, Integer> getHighscores();
}
