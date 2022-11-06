import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
	@Test
	public void canGetStateName() {
		var expectedState="Texas";

		var actualState=States.Texas.Name;

		Assert.assertEquals(actualState, expectedState, "The state name should be returned.");
	}
	
	@Test
	public void canGetStateAbbreviation() {
		var expectedAbbreviation="TX";

		var actualAbbreviation = States.Texas.Abbreviation;

		Assert.assertEquals(actualAbbreviation, expectedAbbreviation);
	}
	
	@Test
	public void canGetSateNameFromObjectMother() {
		var expectedState = "Louisiana";
		
		var actualState=getState(LocationObjectMothers.NewOrleans());
		
		Assert.assertEquals(actualState, expectedState);
	}
	
	private String getState(LocationObjectMother mother) {
		
		return mother.State.Name;
	}
	
	@Test
	public void canGetNorthCarolina() {
		var expectedState = "North Carolina";
		
		var actualState=getState(LocationObjectMothers.Charlotte());
		
		Assert.assertEquals(actualState, expectedState);
	}
	
	@Test
	public void canGetFlorida() {
		var expectedState = "Florida";
		
		var actualState=getState(LocationObjectMothers.Miami());
		
		Assert.assertEquals(actualState, expectedState);
	}
	
	@Test
	public void canGetWashingtonState() {
		var expectedState = "Washington";
		
		var actualState=getState(LocationObjectMothers.Seattle());
		
		Assert.assertEquals(actualState, expectedState);
	}
}