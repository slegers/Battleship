package model.highscore;

import model.persister.Dumpable;

import java.util.Map;

public interface HighscoreRepoInterface extends Dumpable
{
	boolean addPossibleHighscore(String name, Integer count);

	Map<String, Integer> getHighscores();
}
