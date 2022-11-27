import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageMethods {

	public void canGetToPedalsPage(WebDriver driver) {

		var url = "https://ampeg.com/";
		var addedUrl = "products/pedals/";
		var fullURL = url.concat(addedUrl);

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/products/']")).click();
		driver.findElement(By.xpath("//a[@href='/products/pedals/splash']")).click();

		var currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(fullURL, currentUrl, "Should navigate to the pedals page");
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
	public void canCheckPedalsUsingChrome() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Chrome");
		WebDriver driver = GenericDriverManager.getDriver();

		canGetToPedalsPage(driver);
		driver.quit();
	}

	public void canGetToProductsPage(WebDriver driver) {
		var url = "https://ampeg.com/";
		var addedUrl = "products/";
		var fullUrl = url.concat(addedUrl);

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/products/']")).click();
		var currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(fullUrl/* actual */, currentUrl/* expected */,
				"Should navigate to the products page using Google Chrome");
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
	public void canGetToProductsPageInChrome() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager GenericDriverManager = DMV.getManager("Chrome");
		WebDriver driver = GenericDriverManager.getDriver();

		canGetToProductsPage(driver);
		driver.quit();
	}

}
