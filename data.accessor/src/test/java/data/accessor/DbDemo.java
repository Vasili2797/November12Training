package data.accessor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbDemo {

	private static final String userName = "root";
	private static final String password = "password";
	private static final String serverName = "localhost";
	private static final int portNumber = 3306;
	private static final String dbName = "sakila";
	private static final String tableName = "JDBC_TEST";

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection(
				"jdbc:mysql://" + this.serverName + ":" + this.portNumber + "/" + this.dbName, connectionProps);

		return conn;
	}

	public boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command);
			return true;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	private String getJdbcUrl() {
		return "jdbc:mysql://" + this.serverName + ":" + this.portNumber + "/" + this.dbName;
	}

	public void run() {
		Connection conn;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
		String sqlToExecute = "select * from sakila.city\r\n" + "order by city desc limit 10";

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sqlToExecute);
			while (rs.next()) {
				String supplierID = rs.getString("city_id");
				String price = rs.getString("city");
				int sales = rs.getInt("country_id");
				Date total = rs.getDate("last_update");

				System.out.println(supplierID + ", " + price + ", " + sales + ", " + total);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DbDemo app = new DbDemo();
		app.run();
	}
}