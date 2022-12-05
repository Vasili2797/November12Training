package DriverManagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var driverPath = "C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", driverPath);
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");

		var expectedResult = "https://www.google.com/";
		var result = driver.getCurrentUrl();

		Assert.assertEquals(result, expectedResult);
		driver.quit();
	}
}
