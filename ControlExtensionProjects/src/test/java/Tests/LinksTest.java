package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DriverManagers.ChromeDriverManager;
import DriverManagers.DriverManager;

public class LinksTest {
	@Test
	public void canClickOnCreated() {
		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/links");
		driver.manage().window().maximize();
		driver.findElement(By.id("created")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		var result = driver.findElement(By.id("linkResponse")).getText();
		driver.quit();
		Assert.assertEquals(result, "Link has responded with staus 201 and status text Created",
				"Link did not get created");
	}
}
