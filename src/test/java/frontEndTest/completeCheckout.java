package frontEndTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import FrontEnd.PageObject.CartPagePageObject;
import FrontEnd.PageObject.CheckoutPageObject;
import FrontEnd.PageObject.LandingPageObject;
import FrontEnd.PageObject.ProductCatalogPageObject;

public class completeCheckout {
	String productName = "ZARA COAT 3";
	WebDriver driver = new ChromeDriver();
	
	public static void main(String args[]) {
		completeCheckout cc = new completeCheckout();
		cc.checkoutProcess();
	}  
	public void checkoutProcess()  {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));
		LandingPageObject lp = new LandingPageObject(driver);
		lp.goToLanding();
		lp.loginApplication("manoharkantjoshi@gmail.com", "Admin123");
		ProductCatalogPageObject pc = new ProductCatalogPageObject(driver);
		pc.addToCart(productName);
		pc.goToCartPage();
		CartPagePageObject cp = new CartPagePageObject(driver);
		cp.buyNow();
		CheckoutPageObject ccp = new CheckoutPageObject(driver);
		ccp.placeOrder();
	}
}
