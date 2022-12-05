package DriverManagers;


public class DriverManagerFactory {

	public static DriverManager getManager(String browserType) {
		
		if(browserType.equals("chrome")) {
			return new ChromeDriverManager();
		}
		throw new RuntimeException(browserType + " is not a supported browsertype.");
		
	}

}
