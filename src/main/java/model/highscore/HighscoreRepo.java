package model.highscore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class HighscoreRepo implements HighscoreRepoInterface
{
	static boolean made = true;

	Map<String, Integer> scores = new HashMap<>();

	private HighscoreRepo()
	{
	}
	//TODO beter singleton van maken dan
	static HighscoreRepo createHighscoreRepo()
	{
		if (made)
		{
			made = false;
			return new HighscoreRepo();
		}
		throw new IllegalStateException("Highscore already instantiated");
	}


	@Override
	public boolean addPossibleHighscore(String name, Integer count)
	{
		assert !name.contains("@");
		if (scores.size() < 3)
		{
			scores.put(name, count);
			return true;
		} else if (scores.values().stream().anyMatch(obj -> obj < count))
		{
			Map.Entry<String, Integer> lowest = scores.entrySet().stream().findAny().get();
			for (Map.Entry<String, Integer> entry : scores.entrySet())
			{
				if (entry.getValue() < lowest.getValue())
					lowest = entry;
			}
			scores.remove(lowest.getKey());
			scores.put(name, count);
			return true;
		} else
		{
			return false;
		}
	}

	@Override
	public Map<String, Integer> getHighscores()
	{
		return scores;
	}

	@Override
	public List<String> getValues()
	{
		return scores.entrySet().stream().map(obj -> obj.getKey() + "@" + obj.getValue()).collect(Collectors.toList());
	}

	@Override
	public void setValues(List<String> values)
	{
		values.forEach(obj -> scores.put(obj.split("@")[0], Integer.valueOf(obj.split("@")[1])));
	}
}

