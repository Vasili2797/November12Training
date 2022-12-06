package Tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectMenuTests {
	WebDriver driver;

	@Test
	public void getThirdOptionInStringArray() {
		// ChromeDriverManager();
		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");

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
	public void getAllOptionsInStringArray() {// They are the same, but assertEquals says not true

		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement t = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(t);

		List<WebElement> optionList = select.getOptions();

		List<String> stringArray = new ArrayList<String>();
		for (WebElement e : optionList) {
			stringArray.add(e.getText());
		}
		String[] str = new String[optionList.size()];
		for (int i = 0; i < stringArray.size(); i++) {
			str[i] = stringArray.get(i);
		}

		String[] ValuesOnline = new String[] { "Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet",
				"Indigo", "Magenta", "Aqua" };

		var expected = Arrays.toString(ValuesOnline);

		Assert.assertEquals(stringArray/* actual */, expected/* expected */);

		driver.quit();
	}

	@Test
	public void getTwoSelectedOptions() {
		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Select select = new Select(driver.findElement(By.id("cars")));
		select.selectByIndex(1);
		select.selectByIndex(2);

		List<WebElement> list = select.getAllSelectedOptions();
		list.stream().toArray();

		String[] strArray = new String[list.size()];

		for (WebElement i : list) {
			for (int j = 0; j <= 2; j++) {
				strArray[j] = i.getText();
				System.out.println(strArray[j]);
			}

		}
	}
}
