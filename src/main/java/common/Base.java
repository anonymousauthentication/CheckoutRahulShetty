package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Base {
	public Properties prop;
	FileInputStream files;
	public static WebDriver driver;

	public void initialBrowser() throws IOException {
		getGlobalData();
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Inside chro,e");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {

		} else {
			System.out.println("Choose Another Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		@SuppressWarnings("deprecation")
		String jsonContent = FileUtils
				.readFileToString(new File(filePath));
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
	
	public String getScreenShot(String TestCaseName) throws IOException {
		TakesScreenshot tc =  (TakesScreenshot)driver;
		File source = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/reports"+TestCaseName+".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir") + "/reports"+TestCaseName+".png";
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

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
