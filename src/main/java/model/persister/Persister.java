package model.persister;

import java.util.List;

public interface Persister
{
	void init();

	void save(List<Dumpable> toDump);
}
