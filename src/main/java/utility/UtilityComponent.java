package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityComponent extends UtilityComponentLocator {
 WebDriver driver;
	public UtilityComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    
	public void waitForVisibility(By findBy) {
		WebDriverWait wt = new  WebDriverWait(driver, Duration.ofSeconds(5));
		 wt.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitFordisAppear(By findBy) {
		WebDriverWait wt = new  WebDriverWait(driver, Duration.ofSeconds(5));
		 wt.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void goToCartPage()  {
		waitForItemToClickable(cartButton);

		cartButton.click();
	}

	public void waitForItemToClickable(WebElement el) {
		WebDriverWait wt = new  WebDriverWait(driver, Duration.ofSeconds(8));
		wt.until(ExpectedConditions.elementToBeClickable(el));
		wt.until(ExpectedConditions.visibilityOf(el));
	}
	
	public void scrollToBottom(int to , int from) {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+to+","+from+")", "");
	}
}
