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
	public void canGetCity() {
		var expectedCity="Houston";
		
		var actualCity = Cities.Houston.Name;
		
		Assert.assertEquals(actualCity, expectedCity, "the city name is wrong");
	}
	
	@Test
	public void canGetStateAbbreviation() {
		var expectedAbbreviation="TX";

		var actualAbbreviation = States.Texas.Abbreviation;

		Assert.assertEquals(actualAbbreviation, expectedAbbreviation, "abbreviation should be returned");
	}

	@Test
	public void canGetSateNameFromObjectMother() {
		var expectedState = "Louisiana";

		var actualState=getState(LocationObjectMothers.NewOrleans());

		Assert.assertEquals(actualState, expectedState, "state should be returned");
	}

	@Test
	public void canGetCityFromObjectMother() {
		var expectedCity = "Houston";

		var actualCity=LocationObjectMothers.Houston().City.Name;

		Assert.assertEquals(actualCity, expectedCity, "the city name should be returned");
	}
	
	@Test
	public void canGetStateFlowerFromObjectMother() {
		var expectedFlower="Saguaro";
		
		var actualFlower=LocationObjectMothers.FlagStaff().Flower.Name;
		
		Assert.assertEquals(actualFlower, expectedFlower, "the state flower should be returned.");
		
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

	private String getState(LocationObjectMother mother) {

		return mother.State.Name;
	}

}