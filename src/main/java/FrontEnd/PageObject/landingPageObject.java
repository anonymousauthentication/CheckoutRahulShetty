package FrontEnd.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPageObject {
	WebDriver driver;

	public landingPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPass;

	@FindBy(id = "login")
	WebElement login;

	public void loginApplication(String userName, String password) {
		userEmail.sendKeys(userName);
		userPass.sendKeys(password);
		login.click();
	}

	public void goToLanding() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
