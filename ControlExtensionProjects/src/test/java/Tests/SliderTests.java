package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
	public void getSliderAtEighty() {
		Slider slider = new Slider();
		slider.setValue(80);
		int sliderValue = slider.getValue();
		System.out.println(sliderValue);
		slider.quit();
		Assert.assertEquals(sliderValue, 80, "The expected number should be 80");
	}

	@Test
	public void getSliderAtSeventeen() {
		Slider slider = new Slider();
		slider.setValue(17);
		int sliderValue = slider.getValue();
		slider.quit();
		Assert.assertEquals(sliderValue, 17, "The expected number should be 17");
	}

	@Test
	public void getSliderAtZero() {
		Slider slider = new Slider();
		slider.setValue(0);
		int sliderValue = slider.getValue();
		slider.quit();
		Assert.assertEquals(sliderValue, 0, "The expected number should be 0");
	}

	@Test
	public void getSliderAtHundred() {
		Slider slider = new Slider();
		slider.setValue(100);
		int sliderValue = slider.getValue();
		slider.quit();
		Assert.assertEquals(sliderValue, 100, "The expected number should be 100");
	}
}
