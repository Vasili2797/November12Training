import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmpegTests {

	@Test
	public void getPF_800ProductDetails() {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://ampeg.com/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[title='Products']")).click();
		driver.findElement(By.xpath("//a[@href='portaflex/']")).click();
		driver.findElement(By.cssSelector("a[href='heads.html#pf-800']")).click();
		var currentURL = driver.getCurrentUrl();

		assertEquals(currentURL, "https://ampeg.com/products/portaflex/heads.html#pf-800",
				"The website link should be of portaflex product PF-800");
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void buyAProduct() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://ampeg.com/index.html");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("a[title='Shop']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Reject all')]")).click();
		driver.findElement(By.xpath(
				"//div[@class='card-body']//h3[@class='card-title']//a[contains(text(), 'Two Tone Windbreaker')]"))
				.click();
		driver.findElement(By.cssSelector("#attribute_select_126")).click();
		WebDriverWait w = new WebDriverWait(driver, 3);

		driver.findElement(By.xpath("//option[contains(text(),'MD')]")).click();
		w.until(ExpectedConditions
				.elementSelectionStateToBe(driver.findElement(By.xpath("//option[contains(text(),'MD')]")), true));

		driver.findElement(By.xpath("//input[@id='form-action-addToCart']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'View or edit your cart')]")).click();

		var resultText = driver.findElement(By.xpath("//a[@class='cart-item-name__label']")).getText();
		var size = driver.findElement(By.xpath("//dd[@class='definitionList-value']")).getText();
		var price = driver.findElement(By.xpath("//strong[contains(text(),'$59.99')]")).getText();

		assertEquals(resultText, "Two Tone Windbreaker");
		assertEquals(size, "MD");
		assertEquals(price, "$59.99");
		driver.quit();
	}

	@Test
	public void getToTheManuals() {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://ampeg.com/index.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(text(),'Technical Library')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Knowledge Base/')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Ampeg Compatibility Chart.pdf')]")).click();

		assertEquals(driver.getCurrentUrl(),
				"https://ampeg.com/support/files/Knowledge%20Base/Ampeg%20Compatibility%20Chart.pdf",
				"Should be a pdf file ");
		driver.quit();
	}
}
