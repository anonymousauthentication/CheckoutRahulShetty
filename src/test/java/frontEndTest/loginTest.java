package frontEndTest;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrontEnd.PageObject.LandingPageObject;
import common.Base;

public class loginTest extends Base {
	@Test(groups = "Login", dataProvider="getData")
	public void login2(String userName,  String passWord) throws IOException {
		getGlobalData();
		//String userName = prop.getProperty("userName");
		//String passWord = prop.getProperty("password");
		LandingPageObject lp = new LandingPageObject(driver);
		lp.loginApplication(userName, passWord);
	}
	
	public void login(HashMap<String, String> input) throws IOException {
		getGlobalData();
		//String userName = prop.getProperty("userName");
		//String passWord = prop.getProperty("password");
		LandingPageObject lp = new LandingPageObject(driver);
		lp.loginApplication(input.get("email"), input.get("password"));
	}

	@DataProvider
	public Object[][] getData() {
    return new Object[][] {{"manoharkantjoshi@gmail.com","Admin123"},{"abc@gmail.com","Admin123"}};
	}
	
	public void getDataHash() {
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("email", "manoharkantjoshi@gmail.com");
		map.put("password", "Admin123");
	}
	
}
