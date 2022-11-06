public class LocationObjectMothers {

	public static LocationObjectMother NewOrleans() {

		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(Cities.NewOrleans)
				.build();
	}
	
	public static LocationObjectMother Houston() {
		return new LocationBuilder()
				.withState(States.Texas)
				.withCity(Cities.Houston)
				.build();
	}
	
	public static LocationObjectMother Charlotte() {
		return new LocationBuilder()
				.withState(States.northCarolina)
				.withCity(Cities.Charlotte)
				.build();
	}
	
	public static LocationObjectMother Miami() {
		return new LocationBuilder()
				.withState(States.Florida)
				.withCity(Cities.Miami)
				.build();
	}
	
	public static LocationObjectMother Seattle() {
		return new LocationBuilder()
				.withState(States.Washington)
				.withCity(Cities.Seattle)
				.build();
	}
}