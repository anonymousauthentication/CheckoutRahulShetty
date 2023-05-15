package frontEndTest;

import org.testng.annotations.Test;
import FrontEnd.PageObject.CartPagePageObject;
import FrontEnd.PageObject.CheckoutPageObject;
import FrontEnd.PageObject.ProductCatalogPageObject;
import common.Base;

public class completeCheckoutTest extends Base {
	String productName = "ZARA COAT 3";

	@Test(dependsOnGroups = "Login")
	public void checkoutProcess()  {
		ProductCatalogPageObject pc = new ProductCatalogPageObject(driver);
		pc.addToCart(productName);
		CartPagePageObject cp = pc.goToCartPage();
		CheckoutPageObject ccp = cp.buyNow();
		ccp.placeOrder();
	}
}
