package frontEndTest;

import java.io.IOException;

import org.testng.annotations.Test;

import FrontEnd.PageObject.LandingPageObject;
import common.Base;

public class loginTest extends Base {
@Test(groups="Login",dependsOnGroups="LaunchBrowser")
	public void login() throws IOException {
		getGlobalData();
		String userName = prop.getProperty("userName");
		String passWord = prop.getProperty("password");
		LandingPageObject lp = new LandingPageObject(driver);
		lp.loginApplication(userName, passWord);

	}
}
