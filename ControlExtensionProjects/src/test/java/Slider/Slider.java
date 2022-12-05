package Slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		return sliderValue;
		
	}

	public void setValue(int sliderValue) {
		this.sliderValue = sliderValue;
		WebElement slider = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='sliderContainer']/div")));
		slider.getAttribute("value");
		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(slider, sliderValue, 0).build();

		action.perform();
	}
}
