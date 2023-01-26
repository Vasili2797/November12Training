package driver;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		
		var edgeDriverPath = "C:\\temp\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", edgeDriverPath);

		this.driver = new EdgeDriver();
	}
	
	public EdgeDriverManager() {
		this.createDriver();
	}

}
