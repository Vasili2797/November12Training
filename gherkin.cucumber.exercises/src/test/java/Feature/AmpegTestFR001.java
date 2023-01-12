package Feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmpegTestFR001 {
	
	WebDriver driver = null;
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("Inside Step - Browser is on website");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://ampeg.com/index.html");
		
		driver.manage().window().maximize();
	}

	@When("user clicks products Tab")
	public void user_clicks_products() {
		System.out.println("Inside Step - user clicks the products link");
		driver.findElement(By.xpath("//a[@title='Products']")).click();
	}

	@When("clicks on particular product")
	public void clicks_on_particular_product() {
		System.out.println("Inside Step - User clicks on particular product");
	}

	@Then("user sees products from different brands and artists who endorse it")
	public void user_sees_products_from_different_brandsand_artists_who_endorse_it() {
		System.out.println("Inside Step - User sees who endorses product clicked");
	}
}
