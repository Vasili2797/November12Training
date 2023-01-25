
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	protected int counter = 1;
	protected int retryLimit = 2;

	public boolean retry(ITestResult result) {
		System.out.println(counter);
		boolean analyzer = counter++ <= retryLimit;
		return analyzer;
	}
}
