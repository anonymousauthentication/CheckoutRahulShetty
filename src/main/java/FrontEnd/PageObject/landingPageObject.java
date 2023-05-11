package FrontEnd.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilityComponent;

public class LandingPageObject extends UtilityComponent {
	WebDriver driver;

	public LandingPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPass;

	@FindBy(id = "login")
	WebElement login;

	public void loginApplication(String userName, String password) {
		System.out.println(userName);
		userEmail.sendKeys(userName);
		userPass.sendKeys(password);
		login.click();
	}

	public void goToLanding() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
