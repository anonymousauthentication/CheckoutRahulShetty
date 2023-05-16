package FrontEnd.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.UtilityComponent;

public class CheckoutPageObject extends UtilityComponent {
	WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder=\"Select Country\"")
	WebElement selectCountry;

	@FindBy(css = "button span")
	List<WebElement> selectCountryfromOption;

	@FindBy(css = "button span")
	WebElement selectCountryfromOption1;

	@FindBy(css = ".action__submit")
	WebElement placeOrder;

	@FindBy(tagName = "h1")
	WebElement orderText;

	public void placeOrder() {
		selectCountry.sendKeys("ind");
		waitForItemToClickable(selectCountryfromOption1);
		for (int i = 0; i < selectCountryfromOption.size(); i++) {
			System.out.println("For loop");
			if (selectCountryfromOption.get(i).getText().equalsIgnoreCase("India")) {
				selectCountryfromOption.get(i).click();
				break;
			}
		}
		scrollToBottom(500, 100);
		placeOrder.click();
		System.out.println(orderText.getText());

	}
}
