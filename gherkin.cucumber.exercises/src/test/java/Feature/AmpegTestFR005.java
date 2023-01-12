package Feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmpegTestFR005 {

	WebDriver driver = null;

	@Given("user is on the home page FR005")
	public void user_is_on_home_page() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://ampeg.com/index.html");

		driver.manage().window().maximize();

		System.out.println("Inside Step - Browser is on website");
	}

	@When("user clicks Shop link on top of webpage")
	public void clickShopLinkOnTopOfPage() {
		System.out.println("Inside Step - user clicks the Shop link");
		driver.findElement(By.xpath("//a[@title='Shop']")).click();
	}

	@Then("user clicks Software anchor link on top navigation")
	public void clickSoftwareAnchorLink() {
		System.out.println("Inside Step - user clicks the Software anchor tag");
		driver.findElement(By.xpath("//a[@href='https://shop-us.ampeg.com/software/']")).click();
	}

	@And("adds 'SVT Suite' to cart")
	public void addSVTSuite() {
		System.out.println("Inside Step - user adds a music item to cart");
		driver.findElement(By.xpath("//a[contains(text(),'Add to Cart')]")).click();
	}

	@Then("user clicks MERCH dropdown menu")
	public void merchButtonClick() {
		System.out.println("Inside Step - user Clicks Merch dropdown menu");
		driver.findElement(By.xpath("//a[@aria-label='Merch']")).click();
	}

	@And("selects Headwear")
	public void selectHeadwear() {
		System.out.println("Inside Step - User selects 'Headwear' from dropdown menu");

		driver.findElement(By.xpath("//a[contains(text(),'Headwear')]")).click();
	}

	@When("Webpage opens and the user selects 'Classic Snap Back Hat'")
	public void selectClassicSnapBackHat() {
		System.out.println("Inside Step - User selects 'Classic Snap Back Hat'");
		driver.findElement(By.xpath("//a[contains(text(),'Classic Snap Back Hat')]")).click();
	}

	@And("user Adds the item to cart")
	public void addItemsToCart() {
		System.out.println("Inside Step - Adding item to cart");
		driver.findElement(By.id("form-action-addToCart")).click();
	}

	@Then("selects 'View or Edit your cart' anchor tag")
	public void viewOrEditYourCart() {
		System.out.println("Inside Step - View or Edit your cart");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'View or edit your cart')]")));
		driver.findElement(By.xpath("//a[contains(text(),'View or edit your cart')]")).click();
	}

}
