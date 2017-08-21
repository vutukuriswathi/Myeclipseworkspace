package testCases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import abcWebService.WebServiceTest;
import base.BasePage;

public class TestWebServices extends BasePage {

	/*
	 * Section (c) jSon / API Integratin tests
	 * 
	 * 1) Verify the key/value pairs from the following jSon output
	 * 
	 * 2) Let’s assume we want to run the previous tests again but this time
	 * against different environments (note these environments do not exist),
	 * example: How would you develop your tests so that you can run these same
	 * tests against many other environments?
	 * 
	 * 3) We have many programs that have a unique id (key/value arid. See
	 * attached files or url outputs) that can be accessed via public APIs,
	 * where the domain and url structure is exactly same save for the actual
	 * program ID at the end.
	 */

	@Test(priority = 1)
	public void WebServiceTesting() throws ClientProtocolException, IOException {
		WebServiceTest.testWebService();
	}
}
