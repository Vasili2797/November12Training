package Feature;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmpegTestFR003 {
	
	WebDriver driver = null;

	@Given("user is on home page FR003")
	public void user_is_on_home_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nashv\\Downloads\\chromedriver_win32\\chromedriver.exe");
		

		driver = new ChromeDriver();
		driver.get("https://ampeg.com/index.html");

		driver.manage().window().maximize();
		
		System.out.println("Inside Step - Browser is on website");
	}
	
	@When("user clicks on SHOP tab and sees hardware link")
	public void userClicksOnShopTab() {
		System.out.println("Inside Step - user clicks the products link");
		driver.findElement(By.xpath("//a[@title='Shop']")).click();
	}
	
	@Then("user clicks HARDWARE drop down menu")
	public void UserClicksProduct() {
		System.out.println("Inside Step - user clicks the HARDWARE ");
		driver.findElement(By.xpath("//a[@aria-label='Hardware']")).click();
	}
	
	@And("user clicks on Rocket Bass Series option")
	public void userClicksRocketBassSeries() {
		System.out.println("Inside Step - user clicks the products link");
		driver.findElement(By.xpath("//a[@aria-label='Rocket Bass Series']")).click();
	}
	
	@Then("user clicks on a specific product")
	public void canClickRocketBassRB_110ComboBassAmp(){
		System.out.println("Inside Step - user clicks the products link");
		driver.findElement(By.linkText("Rocket Bass RB-110 Combo Bass Amp")).click();
	}
	
	@Then("user clicks Find a Dealer button")
	public void findADealerButton() {
		driver.findElement(By.xpath("//a[@title='Find a dealer']")).click();
		System.out.println("Then user sees all the dealers");
	}
	@And("sees all the available retailers")
	public void assertions() throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		var actualResult=driver.findElement(By.xpath("//a[@href='#oma-online-market']")).getText();
		var expectedResult = "Online Retailers";
		assertEquals(actualResult, expectedResult, "expected online retailers");
		
	}
	@And("customer leaves website")
	public void quitDriver() {
		driver.quit();
	}
	
}
