package foundation;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var driverPath = "C:\\Users\\dtaylor\\Downloads\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		this.setDriver(new ChromeDriver());
	}
}
