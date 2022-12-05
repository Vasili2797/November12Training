package Slider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Slider {
	private int sliderValue;
	WebDriver driver;

	public Slider() {
		var driverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/slider");
	}

	public int getValue() {
		var number1 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='sliderValue']")))
				.getAttribute("value");
		return Integer.parseInt(number1);
	}

	public void setValue(int sliderValue) {
		this.sliderValue = sliderValue;

		int currentValue = getValue();
		if (currentValue > sliderValue) {
			moveLeft();
		} else {
			moveRight();
		}
	}

	private void moveRight() {
		int currentValue = getValue();
		while (sliderValue >= currentValue + 1) {
			WebElement slider = (new WebDriverWait(driver, 10)).until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sliderContainer']/div/span/input")));
			slider.sendKeys(Keys.ARROW_RIGHT);
			currentValue = getValue();
		}
	}

	private void moveLeft() {
		int currentValue = getValue();

		while (sliderValue + 1 <= currentValue) {
			WebElement slider = (new WebDriverWait(driver, 10)).until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sliderContainer']/div/span/input")));
			slider.sendKeys(Keys.ARROW_LEFT);
			currentValue = getValue();
		}
	}
	
	public void quit() {
		driver.quit();
	}
}
