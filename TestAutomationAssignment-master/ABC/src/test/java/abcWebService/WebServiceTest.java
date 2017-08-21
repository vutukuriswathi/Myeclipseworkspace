package abcWebService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.testng.Assert;

import base.BasePage;

public class WebServiceTest extends BasePage {

	public static void testWebService() throws ClientProtocolException, IOException {

		int rowCount = excel.getRowCount("WebServiceTest Request");
		log.debug("WebServices Count in Excel is: "+rowCount);

		if (rowCount == 2) {
			Assert.fail("Input Sheet for WebService Testing is empty");
			log.debug("Input Sheet for WebService Testing is empty");
		} else {
			log.debug("WebService Testing Sheet is not empty");
			for (int i = 3; i <= rowCount; i++) {
				String testEnv = excel.getCellData("WebServiceTest Request", "Environment", i);
				log.debug("Test Env. is: " + testEnv);

				String webServiceUnderTest = excel.getCellData("WebServiceTest Request", "WebService Under Test", i);
				log.debug("Test URL is: " + webServiceUnderTest);

				CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpGet getRequest = new HttpGet(webServiceUnderTest);
				log.debug("Executing request " + getRequest.getRequestLine());

				CloseableHttpResponse response = httpclient.execute(getRequest);
				int status = response.getStatusLine().getStatusCode();

				if (status >= 200 && status < 300) {

					BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
					String outResponse = br.readLine();
					log.debug("*************************************************************");
					log.debug(outResponse);
					log.debug("*************************************************************");

					JSONObject object = new JSONObject(outResponse);

					Object Entity = object.get("entity");
					Object Arid = object.get("arid");
					Object Title = object.get("title");
					Object Mini_synopsis = object.get("mini_synopsis");
					Object Short_synopsis = object.get("short_synopsis");
					Object Medium_synopsis = object.get("medium_synopsis");
					Object Created_utc = object.get("created_utc");
					Object Last_updated_utc = object.get("last_updated_utc");

					String entity = (String) Entity;
					String arid = (String) Arid;
					String title = (String) Title;
					String mini_synopsis = (String) Mini_synopsis;
					String short_synopsis = (String) Short_synopsis;
					String medium_synopsis = (String) Medium_synopsis;
					String created_utc = (String) Created_utc;
					String last_updated_utc = (String) Last_updated_utc;

					// entity
					excel.setCellData("WebServiceTest Request", "entity", i, entity);
					log.debug(entity);
					Assert.assertEquals(entity, excel.getCellData("WebServiceTest Request", "Entity", i),
							"Failed: Entity value does not match");

					// arid
					excel.setCellData("WebServiceTest Request", "arid", i, arid);
					log.debug(arid);
					Assert.assertEquals(arid, excel.getCellData("WebServiceTest Request", "Arid", i),
							"Failed: Arid value does not match");

					// title
					excel.setCellData("WebServiceTest Request", "title", i, title);
					log.debug(title);
					Assert.assertEquals(title, excel.getCellData("WebServiceTest Request", "Title", i),
							"Failed: Title value does not match");

					// mini_synopsis
					excel.setCellData("WebServiceTest Request", "mini_synopsis", i, entity);
					log.debug(mini_synopsis);
					Assert.assertEquals(mini_synopsis, excel.getCellData("WebServiceTest Request", "Mini Synopsis", i),
							"Failed: Mini Synopsis value does not match");

					// short_synopsis
					excel.setCellData("WebServiceTest Request", "short_synopsis", i, short_synopsis);
					log.debug(short_synopsis);
					Assert.assertEquals(short_synopsis,
							excel.getCellData("WebServiceTest Request", "Short Synopsis", i),
							"Failed: Short Synopsis value does not match");

					// medium_synopsis
					excel.setCellData("WebServiceTest Request", "medium_synopsis", i, medium_synopsis);
					log.debug(medium_synopsis);
					Assert.assertEquals(medium_synopsis,
							excel.getCellData("WebServiceTest Request", "Medium Synopsis", i),
							"Failed: Medium Synopsis value does not match");

					// created_utc
					excel.setCellData("WebServiceTest Request", "created_utc", i, created_utc);
					log.debug(created_utc);
					Assert.assertEquals(created_utc, excel.getCellData("WebServiceTest Request", "Created UTC", i),
							"Failed: Created UTC value does not match");

					// last_updated_utc
					excel.setCellData("WebServiceTest Request", "last_updated_utc", i, last_updated_utc);
					log.debug(last_updated_utc);
					Assert.assertEquals(last_updated_utc,
							excel.getCellData("WebServiceTest Request", "Last Updated UTC", i),
							"Failed: Last Updated UTC value does not match");

				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}

		}
	}

}
