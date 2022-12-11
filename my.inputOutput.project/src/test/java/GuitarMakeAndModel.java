
import com.opencsv.bean.CsvBindByName;

public class GuitarMakeAndModel {

	@CsvBindByName
	private String Make;

	@CsvBindByName
	private String Model;

	@CsvBindByName
	private int StringCount;

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getStringCount() {
		return StringCount;
	}

	public void setStringCount(int stringCount) {
		StringCount = stringCount;
	}
}
