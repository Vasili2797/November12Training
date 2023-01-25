

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		
		return true;
	}

}
