package FrontEnd.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilityComponent;

public class ProductCatalogPageObject extends UtilityComponent {
	WebDriver driver;

	public ProductCatalogPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class=\"card\"]")
	List<WebElement> products;

	By product = By.cssSelector("div[class=\"card\"] div[class=\"card-body\"] button:last-child");
	By link = By.cssSelector("button[routerlink=\"/dashboard/cart\"]");

	public WebElement getProducts(String productName) {
		waitForVisibility(product);
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("h5 b")).getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
	}

	public void addToCart(String productName) {
		WebElement prod = getProducts(productName);
		prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		waitForVisibility(link);
	}
}
