package ABCGroupid.screenshottest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

public class URLTest {

	@Test
	public void test1() throws ClientProtocolException, IOException {
		// CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpClient client = new HttpClient();
		HttpGet request = new HttpGet("http://www.abc.net.au/news/feed/51120/rss.xml");
		request.addHeader("content-type", "application/json");
		request.addHeader("Accept", "application/json");
		HttpResponse response = client.executeMethod(request);
		System.out.println("response is" + response);

	}

}
