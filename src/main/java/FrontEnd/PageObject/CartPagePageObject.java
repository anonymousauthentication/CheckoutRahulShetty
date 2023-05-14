package FrontEnd.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilityComponent;

public class CartPagePageObject extends UtilityComponent {
	WebDriver driver;
	CheckoutPageObject ccp;

	public CartPagePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()=\"Buy Now\"]")
	WebElement buyNowButton;

	public CheckoutPageObject buyNow() {
		waitForItemToClickable(buyNowButton);	
		buyNowButton.click(); 
	    ccp = new CheckoutPageObject(driver);
	    return ccp;
	}
}
