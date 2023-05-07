package FrontEnd.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productCatalogPageObject {
	WebDriver driver;

	public productCatalogPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div[class=\"card\"]")
	List<WebElement> products;
	
	public void 
}
