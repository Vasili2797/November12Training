import org.openqa.selenium.WebDriver;

public abstract class PageObject {
	
	protected WebDriver driver;
	protected String baseUrl;
	private String url;
	
	protected PageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	protected void navigateDirectUrl() {
		var fullUrl = this.baseUrl+getUrl();
		
		this.driver.navigate().to(fullUrl);
	}
	
	protected String getUrl() {
		return url;
	}
	
	protected void setUrl(String url) {
		this.url = url;
	}
}
