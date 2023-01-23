import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class Calculator {

	private static WindowsDriver driver = null;
	private static WebElement CalculatorResult = null;

	@BeforeClass
	public static void setup() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			CalculatorResult = driver.findElementByAccessibilityId("CalculatorResults");
			assertNotNull(CalculatorResult);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@BeforeMethod
	public void Clear() {
		driver.findElementByName("Clear").click();
		assertEquals("0", _GetCalculatorResultText());
	}

	@AfterClass
	public static void TearDown() {
		CalculatorResult = null;
		if (driver != null) {
			driver.quit();
		}
		driver = null;
	}

	@Test
	public void Addition() {
		driver.findElementByName("Two").click();
		driver.findElementByName("Plus").click();
		driver.findElementByName("Five").click();
		driver.findElementByName("Equals").click();
		assertEquals("7", _GetCalculatorResultText());
	}

	@Test
	public void Subtraction() {
		driver.findElementByName("Nine").click();
		driver.findElementByName("Minus").click();
		driver.findElementByName("Five").click();
		driver.findElementByName("Equals").click();
		assertEquals("4", _GetCalculatorResultText());
	}

	@Test
	public void Multiplication() {
		driver.findElementByName("Nine").click();
		driver.findElementByName("Multiply by").click();
		driver.findElementByName("Nine").click();
		driver.findElementByName("Equals").click();
		assertEquals("81", _GetCalculatorResultText());
	}

	@Test
	public void Division() {
		driver.findElementByName("Nine").click();
		driver.findElementByName("Nine").click();
		driver.findElementByName("Divide by").click();
		driver.findElementByName("One").click();
		driver.findElementByName("One").click();
		driver.findElementByName("Equals").click();
		assertEquals("9", _GetCalculatorResultText());
	}

	@Test
	public void Combination() {
		driver.findElementByName("Seven").click();
		driver.findElementByName("Multiply by").click();
		driver.findElementByName("Nine").click();
		driver.findElementByName("Plus").click();
		driver.findElementByName("One").click();
		driver.findElementByName("Equals").click();
		driver.findElementByName("Divide by").click();
		driver.findElementByName("Eight").click();
		driver.findElementByName("Equals").click();
		assertEquals("8", _GetCalculatorResultText());
	}

	protected String _GetCalculatorResultText() {
		return CalculatorResult.getText().replace("Display is", "").trim();
	}

}
