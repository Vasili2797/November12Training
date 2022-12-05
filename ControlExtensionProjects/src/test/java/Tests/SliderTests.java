package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Slider.Slider;

public class SliderTests {
	@Test
	public void canGetToSlider() {

		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/slider");
		driver.quit();

	}
	
	@Test
	public void getSlider() {
		Slider slider = new Slider();
		slider.setValue(80);
		
	}
	
}
