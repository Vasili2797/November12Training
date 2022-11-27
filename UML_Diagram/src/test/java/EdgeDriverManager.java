import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {

		var mSdriverPath = "C:\\Users\\nashv\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", mSdriverPath);

		this.driver = new EdgeDriver();
	}

	public EdgeDriverManager() {
		this.createDriver();
	}
}
