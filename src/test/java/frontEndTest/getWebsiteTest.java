package frontEndTest;

import java.io.IOException;

import org.testng.annotations.Test;

import common.Base;

public class getWebsiteTest extends Base {
	@Test(groups = "LaunchBrowser")
	public void launchWeb() throws IOException {
		getWebsite();
	}
}
