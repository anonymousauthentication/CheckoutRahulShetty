package FrontendTestComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class listener {
	ExtentReports extent;

	public void config() {
		String path = System.getProperty("user.dir") + "//ExtentsReport///index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test report");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Senior SDET", "Manohar");
	}

	@Test
	public void initialDemo() {
		config();
		extent.createTest("Test Started");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		extent.flush();
	}
}
