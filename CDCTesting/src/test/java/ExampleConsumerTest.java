import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class ExampleConsumerTest {

	Map<String, String> headers = MapUtils.putAll(new HashMap<String, String>(),
			new String[] { "Content-Type", "application/json" });

	@Rule
	public PactProviderRule provider = new PactProviderRule("NEWSMOBILEAPI", "localhost", 8080, this);

	@Pact(provider = "NEWSMOBILEAPI", consumer = "ABCNEWSAPP")
	public PactFragment configurationFragment(PactDslWithProvider builder) {
		return builder.given("abcnews app sends a request to newsmobileapi").uponReceiving("validate the below data")
				.path("/api/category/id/44").method("GET").willRespondWith().headers(headers).status(200)
				.body(new PactDslJsonBody().object("status").stringValue("code", "200").stringValue("message", "OK")
						.closeObject().object("data").numberValue("id", 44).stringType("name", "Just In")
						.stringValue("type", "news").stringValue("platform", "ALL").closeObject())
				.toFragment();
	}

	@PactVerification("NEWSMOBILEAPI")
	@Test
	public void testJustIn() throws IOException {
		ExampleProviderTest providerRestClient = new ExampleProviderTest();
		HttpResponse response = providerRestClient.placeRequest("http://localhost:8080");

		Assert.assertEquals(200, response.getStatusLine().getStatusCode());

	}

}