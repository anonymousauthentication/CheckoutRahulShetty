import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrontEnd.PageObject.landingPageObject;
import FrontEnd.PageObject.productCatalogPageObject;

public class checkoutProcess {

	public static void main(String args[]) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		landingPageObject lp = new landingPageObject(driver);
		lp.goToLanding();
		lp.loginApplication("manoharkantjoshi@gmail.com","Admin123");
		productCatalogPageObject pc = new productCatalogPageObject(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div[class=\"card\"] div[class=\"card-body\"] button:last-child")));
		List<WebElement> products = driver.findElements(By.cssSelector("div[class=\"card\"]"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("h5 b")).getText().equals(productName))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		wt.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Buy Now\"]")).click();
		driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")).sendKeys("ind");
		List<WebElement> pp = driver.findElements(By.cssSelector("button span"));
		for (int i = 0; i < pp.size(); i++) {
			if (pp.get(i).getText().equalsIgnoreCase("India")) {
				pp.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(100,500)", "");	
		driver.findElement(By.cssSelector(".action__submit")).click();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
	}
}
