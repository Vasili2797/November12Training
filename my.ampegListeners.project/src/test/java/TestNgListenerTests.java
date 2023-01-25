import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNgListenerTests {

	private int i = 0;
	private int retryLimit = 4;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void canRetryFailedTestUsingTestAnalyzerInTest() {

		System.out.println(++i);

		if (i < retryLimit) {
			boolean doFailTheTest=true;
			
			assertFalse(doFailTheTest);
		}
	}
	
	@Test
	public void canRetryFailedTestUsingAnnotationTransformer() {

		System.out.println(++i);

		if (i < retryLimit) {
			boolean doFailTheTest=true;
			
			assertTrue(false);
		}
	}
	
	@Test
	public void canListenForFailedTests() {
		assertFalse(true);
	}
}
