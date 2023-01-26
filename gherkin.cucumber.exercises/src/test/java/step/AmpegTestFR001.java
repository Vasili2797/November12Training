package step;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmpegTestFR001 {
	
	WebDriver driver = null;
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("Inside Step - Browser is on website");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nashv\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://ampeg.com/index.html");
		
		driver.manage().window().maximize();
	}

	@When("user clicks products Tab")
	public void user_clicks_products() {
		System.out.println("Inside Step - user clicks the products link");
		driver.findElement(By.xpath("//a[@title='Products']")).click();
	}

	@And("clicks on particular product")
	public void clicks_on_particular_product() {
		System.out.println("Inside Step - User clicks on Artists tab");
		driver.findElement(By.xpath("//a[@href='/artists/']")).click();
	}

	@Then("user sees products from different brands and artists who endorse it")
	public void user_sees_products_from_different_brands_and_artists_who_endorses_it() {
		System.out.println("Inside Step - User sees who endorses product clicked");
		driver.findElement(By.linkText("CLASSIC")).click();
	}
	
	@And("we assert that a product is endorsed by a particular artist")
	public void assertionOfResults() {
		System.out.println("Inside Step - we assert that a product is endorsed by a particular artist");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Aden Bubeck')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		var result=driver.findElement(By.xpath("//span[contains(text(),'Aden Bubeck')]")).getText();
		assertEquals(result, "ADEN BUBECK", "Expected Aden Bubeck to endorse the product");
		driver.quit();
	}
}
