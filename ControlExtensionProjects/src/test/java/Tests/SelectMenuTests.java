package Tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectMenuTests {
	@Test
	public void getThirdOptionInStringArray() {
		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();

		WebElement t = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(t);
		String value = "3";
		select.selectByValue(value);

		WebElement o = select.getFirstSelectedOption();
		String selectedOption = o.getText();
		System.out.println(selectedOption);

		Assert.assertEquals(selectedOption, "Yellow", "Zero-index list. Fourth element expected");
		driver.quit();
	}

	@Test
	public void getAllOptionsInStringArray() {

		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement t = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(t);

		List<WebElement> optionList = select.getOptions();
		
		String[] strArray = new String[optionList.size()];
		for (WebElement option : optionList) {
			String gettingOptions = option.getText();
			System.out.println(gettingOptions);
		}
		driver.quit();

	}
}
