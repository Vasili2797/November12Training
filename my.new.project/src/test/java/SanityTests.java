import org.testng.annotations.Test;

public class SanityTests {
  @Test
  public void canRunTest() {
  }
  
  @Test
  public void canUseVar() {
	  String myString="myStringIsThis";
	  var myVarString="myVarTest";
	  String developBranch="changesInThisBranch";
	  String mainBranch="changeInmainBranch";
  }
}
	