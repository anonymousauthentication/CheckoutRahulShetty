package frontEndTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Base;

public class WindowAuth extends Base {
	static String downloadPath = System.getProperty("user.dir");

	public static void main(String args[]) throws IOException, InterruptedException {
		Base bb = new Base();
		bb.initialBrowser();
		fileUpload();
		// winauth();
	}

	public static void winauth() throws IOException {
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();

	}

	public static void fileUpload() throws IOException, InterruptedException {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(downloadPath + "\\src\\main\\java\\resources\\fileupload.exe");
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("processTaskTextBtn"))));
		driver.findElement(By.id("processTaskTextBtn")).click();
		Thread.sleep(5000);
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pickfiles"))));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		File f = new File(downloadPath+"/ManoharResume_page-0001.jpg");
		System.out.println(f.exists());
	}
}
