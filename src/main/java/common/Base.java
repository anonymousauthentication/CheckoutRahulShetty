package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Base {
	public Properties prop;
	FileInputStream files;
	public static WebDriver driver;

	public void initialBrowser() throws IOException {
		getGlobalData();
		 String downloadPath = System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Inside chro,e");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {

		} else {
			System.out.println("Choose Another Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		@SuppressWarnings("deprecation")
		String jsonContent = FileUtils.readFileToString(new File(filePath));
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenShot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot tc = (TakesScreenshot) driver;
		File source = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/reports" + TestCaseName + ".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir") + "/reports" + TestCaseName + ".png";
	}

	@BeforeTest
	public void getWebsite() throws IOException {
		initialBrowser();
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public void getGlobalData() throws IOException {
		prop = new Properties();
		files = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\global.properties");
		prop.load(files);
	}
	
	public void getExcelData() throws IOException {
		System.out.println("Excel");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// get totalsheet counts
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			// match sheet name with "TestData"
			if (workbook.getSheetName(i).equalsIgnoreCase("Testdata")) {
				// get into the sheet
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				Row firstrow = row.next();
				Iterator<Cell> cell = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell ce = cell.next();
					if (ce.getStringCellValue().equalsIgnoreCase("Testdata")) {
					}
					column = k;
				}
				k++;
				System.out.println(k);
				while (row.hasNext()) {
					Row r = row.next();
					r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase");
					Iterator<Cell> cv = r.cellIterator();
					while (cv.hasNext()) {
						System.out.println(cv.next().getStringCellValue());
						System.out.println("Excel1");
					}
				}
			}
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
