package frontEndTest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrontEnd.PageObject.LandingPageObject;
import common.Base;

public class loginTest extends Base {
	@Test(groups = "Login", dataProvider="getData")
	public void login(String userName,  String passWord) throws IOException {
		getGlobalData();
		//String userName = prop.getProperty("userName");
		//String passWord = prop.getProperty("password");
		LandingPageObject lp = new LandingPageObject(driver);
		lp.loginApplication(userName, passWord);
	}

	@DataProvider
	public Object[][] getData() {
    return new Object[][] {{"manoharkantjoshi@gmail.com","Admin123"},{"abc@gmail.com","Admin123"}};
	}
}
