import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

	public WebDriver chromePath() {
		var ChromeDriverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		return new ChromeDriver();
	}

	public WebDriver msEdgeDriverPath() {
		var EdgeDriverPath = "C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		return new EdgeDriver();
	}

	private void canGetConnectedToWebsiteGeneric(WebDriver driver) {
		var fullUrl = "https://ampeg.com/index.html";
		driver.navigate().to(fullUrl);
		var currentUrl = driver.getCurrentUrl();

		driver.manage().window().maximize();

		Assert.assertEquals(currentUrl, fullUrl, "Should navigate to the home page using Google Chrome");
	}

	public void canGetToProductsPageUsingChrome(WebDriver driver) {
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
	public void canGetToProductsPageUsingEdgeDriver() { // works
		WebDriver MsEdgeDriver = msEdgeDriverPath();
		canGetToProductsPageUsingChrome(MsEdgeDriver);
		MsEdgeDriver.quit();
	}

	public void canCheckPedalsInHardwareDrop(WebDriver driver) {
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
	public void canCheckPedalsInHardwareDropUsingMsEdge() {
		WebDriver MsEdgeDriver = msEdgeDriverPath();
		canCheckPedalsInHardwareDrop(MsEdgeDriver);
		MsEdgeDriver.quit();
	}

	@Test
	public void canCheckPedalsInHardwareDropUsingChrome() {
		WebDriver ChromeDriver = chromePath();
		canCheckPedalsInHardwareDrop(ChromeDriver);
		ChromeDriver.quit();
	}
	
	public void canPurchaseSVT(WebDriver driver) throws InterruptedException {
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

	@Test
	public void canPurchaseSVTUsingChromeDriver() throws InterruptedException {
		WebDriver ChromeDriver = chromePath();
		canPurchaseSVT(ChromeDriver);
		ChromeDriver.quit();
	}

	@Test
	public void canPurchaseSVTUsingMsEdge() throws InterruptedException {
		WebDriver MsEdgeDriver = msEdgeDriverPath();
		canPurchaseSVT(MsEdgeDriver);
		MsEdgeDriver.quit();
	}
}
