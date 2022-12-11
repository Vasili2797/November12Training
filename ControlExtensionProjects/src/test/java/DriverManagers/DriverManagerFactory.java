package DriverManagers;

public class DriverManagerFactory {

	public DriverManager getManager(String browserType) {

		if (browserType.equals("chrome")) {
			return new ChromeDriverManager();
		} else if (browserType.equals("edge")) {
			return new EdgeDriverManager();
		}
		throw new RuntimeException(browserType + " is not a supported browsertype.");
	}

}
