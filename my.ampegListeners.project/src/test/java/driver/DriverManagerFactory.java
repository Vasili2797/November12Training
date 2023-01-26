package driver;

import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {

	public DriverManager getManager(String browserType) {
		if (browserType.equals("Chrome")) {
			return new ChromeDriverManager();
		}
		return new EdgeDriverManager();
	}

}