public class LocationBuilder {

	private LocationObjectMother mother;

	public LocationBuilder() {
		this.mother=new LocationObjectMother();
	}
	
	public LocationBuilder withState(State state) {
		this.mother.State=state;
		return this;
	}

	public LocationBuilder withCity(City city) {
		this.mother.City=city;
		return this;
	}
	
	public LocationBuilder withFlower(Flower flower) {
		this.mother.Flower = flower;
		return this;
	}

	public LocationObjectMother build() {
		
		return this.mother;
	}
}