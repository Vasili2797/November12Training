package DriverManagers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	@Override
	public void createDriver() {

		var ChromeDriverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);

		this.driver = new ChromeDriver();
	}

	public ChromeDriverManager() {
		this.createDriver();
	}
}
