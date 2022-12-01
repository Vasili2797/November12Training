import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SanityTests {
  @Test
  public void SanityTest() {
	  
	  var driverpath="C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver", driverpath);
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  var expectedResult = "https://www.google.com/";
	  
	  var result=driver.getCurrentUrl();;
	  
	  Assert.assertEquals(result, expectedResult);
	  driver.close();
  }
}
