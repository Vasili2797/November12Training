package data.accessor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import bsh.This;

public class DatabaseUtility implements DatabaseAccessor {

	String userName;
	String password;
	String serverName;
	int portNumber;
	String dbName;
	Connection conn;

	public DatabaseUtility(String userName, String password, String serverName, int portNumber, String dbName) {
		this.userName = userName;
		this.password = password;
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.dbName = dbName;

		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection(
				"jdbc:mysql://" + this.serverName + ":" + this.portNumber + "/" + this.dbName, connectionProps);
		return conn;
	}

	@Override
	public String[] ExecuteSingleColumn(String sql) {
		DataRow[] results = this.Execute(sql);
		String[] strArray = new String[results.length];
		for (int i = 0; i < results.length; i++) {
			strArray[i] = results[i].getValue(results[i].GetColumns()[0]);
		}
		return strArray;
	}

	@Override
	public String ExecuteSingleCell(String sql) {
		DataRow row = this.Execute(sql)[0];
		return row.getValue(row.GetColumns()[0]);
	}

	@Override
	public DataRow[] Execute(String sql) {
		ArrayList<DataRow> array = new ArrayList<DataRow>();

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();
			String[] columnNames = new String[columnCount];
			for (int i = 1; i <= columnCount; i++) {

				columnNames[i - 1] = metadata.getColumnName(i);
			}
			while (rs.next()) {

				String[] strResults = new String[columnNames.length];
				DataRow row = new DataRowImplementation(columnNames);
				for (int i = 0; i < columnNames.length; i++) {

					row.setValue(columnNames[i], rs.getString(columnNames[i]));
				}
				array.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataRow[] newArray = new DataRow[array.size()];
		for (int i = 0; i < array.size(); i++) {
			newArray[i] = array.get(i);
		}
		return newArray;
	}
}