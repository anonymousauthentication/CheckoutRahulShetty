package FrontendTestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.Base;
import resources.ExtentReporterNG;

public class listener extends Base implements ITestListener {
	public static ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass");
	}
	public void onTestFailure(ITestResult result) {
	//	try {
	//		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		//} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
		test.fail(result.getThrowable());
		String path = null;
		try {
			path = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getTestName());
	}
	
	public void onTestSkipped(ITestResult result) {
		extent.flush();
	}
}
