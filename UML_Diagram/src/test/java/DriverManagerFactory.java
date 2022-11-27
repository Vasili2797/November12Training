import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {
	
	public DriverManager getManager(String browserType) {
		if(browserType.equals("Chrome")) {
			return new ChromeDriverManager();
		}
		return new EdgeDriverManager();
	}
	
	public static void main(String[] args){
		DriverManagerFactory DMV=new DriverManagerFactory();
		
		DMV.parameterizedMethod(DMV, "Chrome");
		DMV.parameterizedMethod(DMV, "Edge");
	}
	
	public void parameterizedMethod(DriverManagerFactory DMV, String browserType){
		
		DriverManager GenericDriverManager = DMV.getManager(browserType);
		WebDriver driver = GenericDriverManager.getDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");

		GenericDriverManager.quitDriver();
	}
}
