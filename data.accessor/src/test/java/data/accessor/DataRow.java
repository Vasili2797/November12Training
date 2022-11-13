package data.accessor;

public interface DataRow {
	String[] GetColumns();
	
	public String getValue(String key);
	public void setValue(String key, String value);
}
