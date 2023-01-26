import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import driver.DriverManager;
import driver.DriverManagerFactory;

public class TestNgListenerTests {

	public void canGetToProductsPage(WebDriver driver) {
		var url = "https://ampeg.com/";
		var addedUrl = "products/";
		var fullUrl = url.concat(addedUrl);

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/products/']")).click();
		var currentUrl = driver.getCurrentUrl();

		assertEquals(currentUrl/* actual */, fullUrl/* expected */,
				"Should navigate to the products page using Google Chrome");
	}

	public void canGetToPedalsPage(WebDriver driver) {

		var url = "https://ampeg.com/";
		var addedUrl = "products/pedals/";
		var fullURL = url.concat(addedUrl);

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/products/']")).click();
		driver.findElement(By.xpath("//a[@href='/products/pedals/splash']")).click();

		var currentUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, fullURL, "Should navigate to the pedals page");
	}

	public void canSeeArtistsPage(WebDriver driver) {
		var url = "https://ampeg.com/";
		var addedUrl = "artists/271/Abbi%20Roth";
		var fullURL = url + addedUrl;

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/artists/']")).click();
		driver.findElement(By.xpath("//a[@href='/artists/271/Abbi Roth']")).click();

		var currentURL = driver.getCurrentUrl();

		assertEquals(currentURL, fullURL, "expected Abbi Roth link");
	}

	public void canPurchaseSVT(WebDriver driver) {
		var url = "https://ampeg.com/";
		var addedUrl = "products/heritage/";
		var fullURL = url.concat(addedUrl);

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/products/']")).click();
		driver.findElement(By.xpath("//a[@href='/products/heritage/splash']")).click();
		driver.findElement(By.xpath("//*[@id='first-prod']//a[@href='#obn']")).click();

		var currentURL = driver.getCurrentUrl();

		assertEquals(currentURL, fullURL);
	}

	@Test
	public void canSeeArtistsPageUsingChrome() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Chrome");
		WebDriver driver = GenericDriverManager.getDriver();

		canSeeArtistsPage(driver);
		driver.quit();
	}

	@Test
	public void canSeeArtistsPageUsingEdge() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Edge");
		WebDriver driver = GenericDriverManager.getDriver();

		canSeeArtistsPage(driver);
		driver.quit();
	}

	@Test
	public void canCheckPedalsUsingChrome() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Chrome");
		WebDriver driver = GenericDriverManager.getDriver();

		canGetToPedalsPage(driver);
		driver.quit();
	}

	@Test
	public void canCheckPedalsUsingMSEdge() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Edge");
		WebDriver driver = GenericDriverManager.getDriver();

		canGetToPedalsPage(driver);
		driver.quit();
	}

	@Test
	public void canGetToProductsPageInChrome() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Chrome");
		WebDriver driver = GenericDriverManager.getDriver();

		canGetToProductsPage(driver);
		driver.quit();
	}

	@Test
	public void canGetToProductsPageInMSEdge() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Edge");
		WebDriver driver = GenericDriverManager.getDriver();

		canGetToProductsPage(driver);
		driver.quit();
	}

	@Test
	public void canPurchaseSVTInChrome() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Chrome");
		WebDriver driver = GenericDriverManager.getDriver();

		canPurchaseSVT(driver);
		driver.quit();
	}

	@Test
	public void canPurchaseSVTInEdge() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Edge");
		WebDriver driver = GenericDriverManager.getDriver();

		canPurchaseSVT(driver);
		driver.quit();
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void canListenForFailedTests() {
		assertFalse(true);
	}
}
