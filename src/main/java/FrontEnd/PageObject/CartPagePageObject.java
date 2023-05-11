package FrontEnd.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilityComponent;

public class CartPagePageObject extends UtilityComponent {
	WebDriver driver;

	public CartPagePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()=\"Buy Now\"]")
	WebElement buyNowButton;

	public void buyNow() {
		waitForItemToClickable(buyNowButton);	
		buyNowButton.click(); 
	}
}
