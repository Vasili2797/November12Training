import com.opencsv.bean.CsvBindByName;

public class Bass {
	@CsvBindByName
	private String Make;

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	@Override
	public boolean equals(Object otherBass) {

		if (otherBass == this) {
			return true;
		}

		if (!(otherBass instanceof Bass)) {
			return false;
		}

		Bass b = (Bass) otherBass;
		if (this.Make.equals(b.getMake())) {
			return true;
		}
		return false;
	}
}
