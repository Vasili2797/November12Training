package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void quitDriver() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}

	public abstract void createDriver();
}