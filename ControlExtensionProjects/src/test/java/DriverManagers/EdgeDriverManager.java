package DriverManagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var edgeDriverPath = "C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", edgeDriverPath);

		this.driver = new EdgeDriver();
	}

	public EdgeDriverManager() {
		this.createDriver();
	}
}
