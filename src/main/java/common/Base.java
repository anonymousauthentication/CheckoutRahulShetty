package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

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
