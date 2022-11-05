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
		
		Assert.assertEquals(actualState.Name, expectedState);
	}

	private State getState(LocationObjectMother mother) {
		// TODO Auto-generated method stub
		return mother.State;
	}
	
}
