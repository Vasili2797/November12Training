package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DriverManagers.DriverManagerFactory;

public abstract class TestBase {
	@Test
	public void setUp() {
		var browserType = "chrome";
//		var manager = DriverManagerFactory.getManager(browserType);
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

}
