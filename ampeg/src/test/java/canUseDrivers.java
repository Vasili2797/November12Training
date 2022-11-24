import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class canUseDrivers {

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
	
	public void msEdgeDriverPath() {
		var EdgeDriverPath="C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		this.driver = new EdgeDriver();
	}

	@Test
	public void canGetConnectedToWebsite() {
		chromePath();
		
		var fullUrl = "https://ampeg.com/index.html";
		driver.navigate().to(fullUrl);
		var currentUrl = driver.getCurrentUrl();

		driver.manage().window().maximize();
		
		Assert.assertEquals(currentUrl, fullUrl, "Should navigate to the home page using Google Chrome");
	}

	@Test
	public void canSeeArtistsPage() throws InterruptedException {
		chromePath();
		
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
}
