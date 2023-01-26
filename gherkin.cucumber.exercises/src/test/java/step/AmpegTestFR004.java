package step;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

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

	@And("user clicked the link Artists")
	public void clickArtistsLink() {
		System.out.println("Inside Step - user clicked the link Artists");

		driver.findElement(By.xpath("//div[@id='global-topnav']//ul[@class='hidden-xs']//li//a[@title='Artists']"))
				.click();
		driver.findElement(By.xpath("//a[contains(text(),'VIEW ALL')]")).click();
	}

	@Then("user hovers over the artist link")
	public void hoverOverArtistLink() {
		System.out.println("Inside Step - user hovers over the artist link");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Aden Bubeck')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

	@And("Get The name of an artist and assert")
	public void getArtistName() {
		System.out.println("Inside Step - Get The name of an artist and assert");
		var result = driver.findElement(By.xpath("//span[contains(text(),'Aden Bubeck')]")).getText();
		assertEquals(result, "ADEN BUBECK", "Aden Bubeck should also be in the list");
		driver.quit();
	}

}
