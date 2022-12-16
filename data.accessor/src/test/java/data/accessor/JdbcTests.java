package data.accessor;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTests {
	private DatabaseUtility accessor;
	private JDBCType template;

	@BeforeMethod
	public void Setup() {
		this.accessor = new DatabaseUtility("root", "password", "localhost", 3306, "sakila");
	}

	@Test
	public void canAccessDatabase() {
		var result = this.accessor.ExecuteSingleCell("SELECT city FROM sakila.city;");
	}

	@Test
	public void canGetTenCitiesInDescendingOrder() {
		String getTenRows = "SELECT city FROM sakila.city" + " ORDER BY city DESC LIMIT 10;";
		String[] expectedArray = new String[] { "Ziguinchor", "Zhoushan", "Zhezqazghan", "Zeleznogorsk", "Zaria",
				"Zapopan", "Zaoyang", "Zanzibar", "Zalantun", "Yuzhou", };

		var result = this.accessor.ExecuteSingleColumn(getTenRows);

		Assert.assertEquals(result, expectedArray);
	}

	@Test
	public void highestPaymentAmount() {
		String GetHighestPayment = "SELECT MAX(amount) FROM sakila.payment;";
		var result = this.accessor.ExecuteSingleCell(GetHighestPayment);
		Assert.assertEquals(result, "11.99");
	}

	@Test
	public void getInfoForBobFawcett() {
		String BobFawcettInfo = "SELECT * FROM film_view;";
		var result = this.accessor.Execute(BobFawcettInfo);
		result[0].getValue(BobFawcettInfo);
		Assert.assertEquals(result.length, 25);
	}

	@Test
	public void getFourInventoryIDs() {
		String sqlStatementsToComplete = "CALL `sakila`.`film_in_stock`((Select film_id from sakila.film where title=\"Alien Center\"), 2, @_count);";
		var result = this.accessor.Execute(sqlStatementsToComplete);

		String[] expectedArray = new String[] { "73", "74", "75", "76" };
		String[] resultConverted = new String[result.length];

		for (int i = 0; i < result.length; i++) {
			resultConverted[i] = result[i].getValue(result[i].GetColumns()[0]);
		}
		Assert.assertEquals(resultConverted, expectedArray);
	}
}
