package data.accessor;

import java.util.List;

public interface DatabaseAccessor {
	String[] ExecuteSingleColumn(String sql);

	String ExecuteSingleCell(String sql);

	DataRow[] Execute(String sql);
}
