import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SanityTests {
	
	protected WebDriver driver;
	
	@AfterMethod
	public void Cleanup() {
		if(this.driver == null) {
			return;
		}
		this.driver.quit();
	}
	
  @Test
	public void canLaunchChromeDriver() {
		var ChromeDriverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		
		var url = "https://ampeg.com/index.html";
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		
		this.driver = new ChromeDriver();
		driver.navigate().to(url);
		var currentUrl = driver.getCurrentUrl();
		
		driver.manage().window().maximize();
		
		Assert.assertEquals(currentUrl, url, "Should navigate to the home page using Google Chrome");
	}
	
	@Test
	public void canLaunchMsEdgeDriver() {
		var mSdriverPath = "C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		
		var url = "https://ampeg.com/index.html";
		
		System.setProperty("webdriver.edge.driver", mSdriverPath);
		
		this.driver = new EdgeDriver();
		driver.navigate().to(url);
		var currentUrl = driver.getCurrentUrl();
		
		driver.manage().window().maximize();
		
		
		Assert.assertEquals(currentUrl, url, "Should navigate to the home page using Microsoft Edge");
	}
}
