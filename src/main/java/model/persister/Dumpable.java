package model.persister;

import java.util.List;

public interface Dumpable
{
	List<String> getValues();

	void setValues(List<String> values);
}
