import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class canUseDrivers {

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

	private void canConnectToArtistsPage(WebDriver driver) {
		var url = "https://ampeg.com/";
		var addedUrl = "artists/271/Abbi%20Roth";
		var fullURL = url + addedUrl;

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/artists/']")).click();
		driver.findElement(By.xpath("//a[@href='/artists/271/Abbi Roth']")).click();

		var currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, fullURL, "expected Abbi Roth link");
	}
	
	
	@Test
	public void canGetConnectedUsingEdgeDriver() { 
		WebDriver MsEdgeDriver = msEdgeDriverPath();
		canGetConnectedToWebsiteGeneric(MsEdgeDriver);
		MsEdgeDriver.quit();
	}

	@Test
	public void canGetConnectedUsingChromeDriver() {
		WebDriver chromePathDriver = chromePath();
		canGetConnectedToWebsiteGeneric(chromePathDriver);
		chromePathDriver.quit();
	}

	@Test
	public void canSeeArtistsPageUsingEdgeDriver() {
		WebDriver MsEdgeDriver = msEdgeDriverPath();
		canConnectToArtistsPage(MsEdgeDriver);
		MsEdgeDriver.quit();
	}

	@Test
	public void canSeeArtistsPageUsingChromeDriver() {
		WebDriver chromePathDriver = chromePath();
		canConnectToArtistsPage(chromePathDriver);
		chromePathDriver.quit();
	}
}
