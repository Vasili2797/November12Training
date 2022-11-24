import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProductsPageMethods {
	
	protected WebDriver driver;
	
	@AfterMethod
	public void Cleanup() {
		if (this.driver == null) {
			return;
		}
		this.driver.quit();
	}
	
	public void chromePath() {
		var ChromeDriverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		this.driver = new ChromeDriver();
	}

	
	@Test
	public void canGetToProductsPage() {
		chromePath();

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
	public void canCheckPedalsInHardwareDrop() {
		chromePath();

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
	public void canPurchaseSVT() throws InterruptedException {
		chromePath();

		var url = "https://ampeg.com/";
		var addedUrl = "products/pedals/";
		var fullURL = url.concat(addedUrl);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/products/']")).click();
		driver.findElement(By.xpath("//a[@href='/products/heritage/splash']")).click();
		driver.findElement(By.xpath("//*[@id='first-prod']//a[@href='#obn']")).click();
		int windowCount = driver.getWindowHandles().size();
		assertEquals(windowCount, driver.getWindowHandles().size());

	}
}
