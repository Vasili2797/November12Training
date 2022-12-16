package data.accessor;

import java.util.HashMap;

public class DataRowImplementation implements DataRow {
	String columns[];
	HashMap<String, String> actualValues;

	public DataRowImplementation(String[] columns) {
		this.columns = columns;
		this.actualValues = new HashMap<String, String>();
	}

	@Override
	public String[] GetColumns() {
		return columns;
	}

	@Override
	public String getValue(String key) {
		return actualValues.get(key);
	}

	@Override
	public void setValue(String key, String value) {
		actualValues.put(key, value);
	}
}