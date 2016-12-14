package model.highscore;

import model.persister.Dumpable;

import java.util.Map;

/**
 * @author: Louis Roebben
 */
public interface HighscoreRepoInterface extends Dumpable
{
	boolean addPossibleHighscore(String name, Integer count);
	Map<String, Integer> getHighscores();
}
