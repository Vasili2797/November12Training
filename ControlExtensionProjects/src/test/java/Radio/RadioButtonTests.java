package Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import DriverManagers.ChromeDriverManager;

public class RadioButtonTests {

	@Test
	public void canGetYesButton() {
		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();
		driver.findElement(By.className("custom-control-label")).click();

		var result = driver.findElement(By.xpath("//span[contains(text(), 'Yes')]")).getText();
		driver.quit();

		Assert.assertEquals(result, "Yes", "Should return Yes");

	}

	@Test
	public void canGetImpressiveButton() {

		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("impressiveRadio"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		var result = driver.findElement(By.xpath("//span[contains(text(), 'Impressive')]")).getText();
		driver.quit();
		Assert.assertEquals(result, "Impressive", "Should return Impressive");
	}

	// The no button is not clickable
	@Test
	public void canGetNoButton() {
		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("noRadio"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		driver.quit();

	}
}
