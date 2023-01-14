package Feature;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class AmpegTestFR004 {

	WebDriver driver = null;

	@Given("user is on homepage FR004")
	public void user_is_on_home_page() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nashv\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://ampeg.com/index.html");

		driver.manage().window().maximize();

		System.out.println("Inside Step - Browser is on website");
	}
	
	@Test
	@SuppressWarnings("unlikely-arg-type")
	@And("user clicked the link Artists")
	public void canClickArtistsPage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe");

		WebDriver drivers = new ChromeDriver();
		drivers.get("https://ampeg.com/index.html");
		drivers.findElement(By.xpath("//div[@id='global-topnav']//ul[@class='hidden-xs']//li//a[@title='Artists']")).click();
		drivers.findElement(By.xpath("//a[contains(text(),'VIEW ALL')]")).click();
	}
	
}
