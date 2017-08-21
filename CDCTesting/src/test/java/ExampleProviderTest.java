import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;

public class ExampleProviderTest {

	public HttpResponse placeRequest(String baseUrl) throws IOException {

		return Request.Get(baseUrl + "/api/category/id/44").execute().returnResponse();

	}

}