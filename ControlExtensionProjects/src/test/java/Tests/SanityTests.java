package Tests;

import org.testng.annotations.Test;

import DriverManagers.ChromeDriverManager;
import DriverManagers.DriverManager;
import DriverManagers.EdgeDriverManager;;

public class SanityTests {

	@Test
	public void testUsingChromeDriverManager() {

		DriverManager driver = new ChromeDriverManager();
		driver.createDriver();
	}

	@Test
	public void testUsingEdgeDriverManager() {

		DriverManager driver = new EdgeDriverManager();
		driver.createDriver();
	}

}
