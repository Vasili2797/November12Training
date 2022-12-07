package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import DriverManagers.DriverManager;
import DriverManagers.DriverManagerFactory;

public class SelectMenuTests {
	WebDriver driver;

	public void getThirdOptionInStringArray(WebDriver driver) {
		driver.get("https://demoqa.com/select-menu");

		WebElement t = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(t);
		String value = "3";
		select.selectByValue(value);

		WebElement o = select.getFirstSelectedOption();
		String selectedOption = o.getText();

		Assert.assertEquals(selectedOption, "Yellow", "Zero-index list. Fourth element expected");

	}

	public void getAllOptionsInStringArray(WebDriver driver) {

		driver.get("https://demoqa.com/select-menu");

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

		var expected = Arrays.asList(ValuesOnline);

		Assert.assertEquals(stringArray, expected, "Should Have the same values");

		driver.quit();
	}

	public void getTwoSelectedOptions(WebDriver driver) {

		driver.get("https://demoqa.com/select-menu");

		WebElement t = driver.findElement(By.xpath("//select[@id='cars']"));

		Select select = new Select(t);
		select.selectByIndex(1);
		select.selectByIndex(2);

		List<WebElement> list = select.getAllSelectedOptions();
		List<String> str = new ArrayList<String>();
		for (WebElement e : list) {
			str.add(e.getText());
		}

		String[] expectedInArray = { "Saab", "Opel" };

		var expected = Arrays.asList(expectedInArray);
		var actual = str;

		Assert.assertEquals(actual, expected);
		driver.quit();
	}

	@Test
	public void thirdOptionInStringArrayUsingChromeDriver() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("chrome");
		WebDriver driver = genericDriverManager.getDriver();
		driver.manage().window().maximize();
		getThirdOptionInStringArray(driver);
		driver.quit();
	}

	@Test
	public void thirdOptionInStringArrayUsingEdgeDriver() {
		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("edge");
		WebDriver driver = genericDriverManager.getDriver();
		driver.manage().window().maximize();
		getThirdOptionInStringArray(driver);
		driver.quit();
	}

	@Test
	public void getAllOptionsInStringArrayUsingChromeDriver() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("chrome");
		WebDriver driver = genericDriverManager.getDriver();
		driver.manage().window().maximize();
		getAllOptionsInStringArray(driver);
		driver.quit();
	}

	@Test
	public void getAllOptionsInStringArrayUsingEdgeDriver() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("edge");
		WebDriver driver = genericDriverManager.getDriver();
		driver.manage().window().maximize();
		getAllOptionsInStringArray(driver);
		driver.quit();
	}

	@Test
	public void getTwoSelectedOptionsUsingChromeDriver() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("chrome");
		WebDriver driver = genericDriverManager.getDriver();
		driver.manage().window().maximize();
		getTwoSelectedOptions(driver);
		driver.quit();
	}

	@Test
	public void getTwoSelectedOptionsUsingEdgeDriver() {

		DriverManagerFactory DMV = new DriverManagerFactory();
		DriverManager genericDriverManager = DMV.getManager("edge");
		WebDriver driver = genericDriverManager.getDriver();
		driver.manage().window().maximize();
		getTwoSelectedOptions(driver);
		driver.quit();
	}
}
