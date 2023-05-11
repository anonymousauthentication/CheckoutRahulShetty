package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UtilityComponentLocator {

	@FindBy(css = "button[routerlink=\"/dashboard/cart\"]")
	WebElement cartButton;
}
