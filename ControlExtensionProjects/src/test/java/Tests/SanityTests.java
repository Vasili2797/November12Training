package Tests;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DriverManagers.ChromeDriverManager;
import DriverManagers.EdgeDriverManager;;

public class SanityTests {

	@Test
	public void testUsingChromeDriverManager() {

		ChromeDriverManager driver = new ChromeDriverManager();
		driver.createDriver();
	}

	@Test
	public void testUsingEdgeDriverManager() {

		EdgeDriverManager driver = new EdgeDriverManager();
		driver.createDriver();
	}

}
