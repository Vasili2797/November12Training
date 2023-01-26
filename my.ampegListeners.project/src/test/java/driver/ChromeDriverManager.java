package driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var chromeDriverPath = "C:\\temp\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		this.driver = new ChromeDriver();
	}

	public ChromeDriverManager() {
		this.createDriver();
	}
}
