package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports getReportObject() {
		// ExtentReports , ExtentSparkReporter [ in donu classes ka use krna hota h extentReport bnane k liye ]
		String path = System.getProperty("user.dir")+"//ExtentReport//index.html"; // Create Report folder and report.html file		
        ExtentSparkReporter report = new ExtentSparkReporter(path); // is se 1 reports k ander report.html ki file bnegi, usme result show hoga
		report.config().setReportName("Web Automation"); // set report Name 
		report.config().setDocumentTitle("Test Automation  Report"); // Set Page title <title>TestNg ExtentReport</title>
		ExtentReports extent = new ExtentReports(); // is se main report generate hot i h grafically
		extent.attachReporter(report);  // ExtentSparkReporter ko attache krta h. mtlb ExtentSparkReporter k obj ka use k file or folder name get krte h .  
		extent.setSystemInfo("SDET", "Manohar Kant Joshi");  // Testresult m Tester ka name bhi dal skte hai.
		return extent;
	}
}
