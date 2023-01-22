package Feature;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AmpegTestFR002 {
	
	WebDriver driver = null;
	
	@Given("user is on home pages")
	public void user_is_on_home_pages() {
		System.out.println("Inside Step - Browser is on website");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nashv\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://ampeg.com/index.html");
		
		driver.manage().window().maximize();
	}
	
	@When("user clicks on products")
	public void clickProducts() {
		System.out.println("Inside Step - user clicks the products anchor link");
		driver.findElement(By.xpath("//a[@title='Products']")).click();
	}
	
	@And("clicks on MICRO SERIES product link")
	public void clicks_on_micro_series() {
		System.out.println("Inside Step - User Clicks on Micro Series tagname");
		driver.findElement(By.xpath("//img[@src='../images/microseries-productdirectory.jpg']")).click();
	}
	
	@Then("user sees specific details about the chosen product")
	public void see_product_details() {
		System.out.println("Inside Step - User sees details about particular product in MICRO SERIES");
		var result = driver.getTitle();
		assertEquals("Ampeg :: Micro Series", result);
		driver.quit();
	}
	
}
