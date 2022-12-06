package Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import DriverManagers.DriverManager;
import DriverManagers.DriverManagerFactory;

public class RadioButtonTests {

	public void getYesButton(WebDriver driver) {
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();

		driver.findElement(By.className("custom-control-label")).click();

		var result = driver.findElement(By.xpath("//span[contains(text(), 'Yes')]")).getText();

		Assert.assertEquals(result, "Yes", "Should return Yes");
	}

	public void getImpressiveButton(WebDriver driver) {
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.id("impressiveRadio"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);

		var result = driver.findElement(By.xpath("//span[contains(text(), 'Impressive')]")).getText();

		Assert.assertEquals(result, "Impressive", "Should return Impressive");
	}

	public void getNoButton(WebDriver driver) {
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.id("noRadio"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);

		Assert.assertFalse(element.isEnabled());
	}

	@Test
	public void canGetYesButtonUsingChromeDriver() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("chrome");
		WebDriver driver = genericDriverManager.getDriver();

		driver.manage().window().maximize();
		getYesButton(driver);

		driver.quit();
	}

	@Test
	public void canGetYesButtonUsingEdgeDriver() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("edge");
		WebDriver driver = genericDriverManager.getDriver();

		driver.manage().window().maximize();
		getYesButton(driver);

		driver.quit();
	}

	@Test
	public void canGetImpressiveButtonUsingChromeDriver() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("chrome");
		WebDriver driver = genericDriverManager.getDriver();

		driver.manage().window().maximize();
		getImpressiveButton(driver);

		driver.quit();
	}

	@Test
	public void canGetImpressiveButtonUsingEdgeDriver() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("edge");
		WebDriver driver = genericDriverManager.getDriver();

		driver.manage().window().maximize();
		getImpressiveButton(driver);

		driver.quit();
	}

	@Test
	public void canGetNoButtonUsingChromeDriver() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("chrome");
		WebDriver driver = genericDriverManager.getDriver();

		driver.manage().window().maximize();
		getNoButton(driver);

		driver.quit();
	}

	@Test
	public void canGetNoButtonUsingEdgeDriver() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("edge");
		WebDriver driver = genericDriverManager.getDriver();

		driver.manage().window().maximize();
		getNoButton(driver);

		driver.quit();
	}
}