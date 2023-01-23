import org.testng.Assert;
import org.testng.annotations.Test;

public class SanityTests {
  @Test
  public void f() {
	  System.out.println("Make sure it runs");
	  var Expected ="";
	  var actual="";
	  Assert.assertEquals(actual, Expected);
  }
}
