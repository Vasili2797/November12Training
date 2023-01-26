import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.bean.CsvToBeanBuilder;

public class SanityTest {
	@Test
	public void canRunTests() {
		var chromeDriverPath = "C:\\Users\\nashv\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		var actual = driver.getTitle();
		var expected = "Google";

		Assert.assertEquals(actual, expected);
		driver.quit();
	}

	@Test
	public void readFIrstTwoColumnsOfCsvFile() throws IOException { // this one reads first and second rows
		String csvPath = "C:\\Users\\nashv\\git\\November12Training\\my.inputOutput.project\\src\\test\\resources\\9_basses.csv";
		HashMap<String, String> guitarsMakeAndModel = new HashMap<String, String>();

		List<GuitarMakeAndModel> guitars = new CsvToBeanBuilder(new FileReader(csvPath))
				.withType(GuitarMakeAndModel.class).build().parse();

		for (int i = 0; i < guitars.size(); i++) {
			GuitarMakeAndModel guitar = guitars.get(i);
			guitarsMakeAndModel.put(guitar.getModel(), guitar.getMake());

		}

		HashMap<String, String> expectedHashMap = new HashMap<String, String>();

		expectedHashMap.put("Corvette", "Warwick");
		expectedHashMap.put("Thumb", "Warwick");
		expectedHashMap.put("Streamer", "Warwick");
		expectedHashMap.put("Precision", "Fender");
		expectedHashMap.put("Jazz", "Fender");
		expectedHashMap.put("BB500", "Yamaha");

		Assert.assertEquals(guitarsMakeAndModel, expectedHashMap);
	}

	private Bass getBassObject(String make) {
		Bass newBass = new Bass();
		newBass.setMake(make);
		return newBass;
	}

	@Test
	public void canGetBassMakeFromCsv() throws IllegalStateException, FileNotFoundException {
		String csvPath = "C:\\Users\\nashv\\git\\November12Training\\my.inputOutput.project\\src\\test\\resources\\9_basses.csv";
		List<Bass> guitars = new CsvToBeanBuilder(new FileReader(csvPath)).withType(Bass.class).build().parse();
		List<Bass> expectedGuitars = new ArrayList<>();

		expectedGuitars.add(getBassObject("Warwick"));
		expectedGuitars.add(getBassObject("Warwick"));
		expectedGuitars.add(getBassObject("Warwick"));
		expectedGuitars.add(getBassObject("Fender"));
		expectedGuitars.add(getBassObject("Fender"));
		expectedGuitars.add(getBassObject("Yamaha"));

		Assert.assertEquals(guitars, expectedGuitars);
	}
}
