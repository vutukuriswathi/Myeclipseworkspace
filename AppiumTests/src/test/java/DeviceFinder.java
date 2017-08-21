import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class DeviceFinder {
	@Test
	public void test1() throws IOException {

		String url = "https://cloud.testdroid.com/api/v2/devices?limit=0";
		String line = "";
		boolean flag = false;

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		request.addHeader("content-type", "application/json");
		request.addHeader("Accept", "application/json");

		HttpResponse response = client.execute(request);

		System.out.println("Sending GET request to URL :" + url);
		System.out.println("Response Code :" + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();

		while ((line = rd.readLine()) != null)

		{
			result.append(line);
		}

		System.out.println(result.toString());
		String jsonInput = result.toString();

		JSONObject outerObject = new JSONObject(jsonInput);

		JSONArray jsonArray = outerObject.getJSONArray("data");
		for (int i = 0, size = jsonArray.length(); i < size; i++) {
			JSONObject objectInArray = jsonArray.getJSONObject(i);

			JSONObject softwareVersion = new JSONObject((objectInArray.get("softwareVersion")).toString());

			if ((objectInArray.getInt("creditsPrice") == 0) && (objectInArray.getBoolean("locked") == false)
					&& ((String) objectInArray.get("osType")).equals("ANDROID")
					&& softwareVersion.getInt("apiLevel") > 16) {

				System.out.println("found device" + objectInArray.get("displayName"));
				flag = true;
				break;

			}

		}
		if (flag == false)
			System.out.println("No device found");

	}

}
