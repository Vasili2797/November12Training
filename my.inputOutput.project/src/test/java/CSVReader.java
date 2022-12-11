import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public static void main(String[] args) throws IOException {
		File csvFile = new File(
				"C:\\Users\\nashv\\git\\November12Training\\my.inputOutput.project\\src\\test\\resources\\9_basses.csv");
		System.out.println("Hello World");

		BufferedReader reader = new BufferedReader(new FileReader(csvFile));
		String line = "";
		try {
			while ((line = reader.readLine()) != null) {
				String[] count = line.split(", ");
				for (String i : count) {
					System.out.println(i);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
