package com.slurper.recommendations;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import groovy.json.JsonSlurper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Assert;
import org.junit.Test;
import com.jasonslurper.util.Constants;
import com.jasonslurper.util.RecommendationUtil;

public class ExternalAPI {

	RecommendationUtil recUtil = new RecommendationUtil();

	public HttpClient client = new HttpClient();
	public GetMethod request = null;
	public JsonSlurper slurper;
	public Map<Object, Object> jsonResult = null;
	public Map<Object, Object> recommendations = null;
	public Map<String, String> map = null;
	public int statusCode;

	@SuppressWarnings("unchecked")
	@Test
	public void mostPopularPlain() throws HttpException, IOException {
		try {
			request = new GetMethod(Constants.MOSTPOPULAR);
			statusCode = client.executeMethod(request);
			slurper = new JsonSlurper();
			Object jsonResponse = slurper.parseText(request
					.getResponseBodyAsString());

			Assert.assertEquals(Constants.responseHeaders,
					recUtil.getResponseContentType(request));
			Assert.assertEquals(Constants.statusCode, statusCode);
			jsonResult = (Map<Object, Object>) jsonResponse;
			Assert.assertNotNull("The object is null",
					(String) jsonResult.get("RSID"));
			List<Object> recommendObj = (List<Object>) jsonResult
					.get("recommendations");

			map = (Map<String, String>) recommendObj.get(0);
			Assert.assertEquals("Contents did not match", Constants.news,
					map.get("urlcanonical"));

			map = (Map<String, String>) recommendObj.get(1);
			Assert.assertEquals("Contents did not match", Constants.newsjustin,
					map.get("urlcanonical"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			request.releaseConnection();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void mostPopularTripleJ() {
		request = new GetMethod(Constants.MOSTPOPULARTRIPLEJ);
		try {
			statusCode = client.executeMethod(request);
			slurper = new JsonSlurper();
			Object jsonResponse = slurper.parseText(request
					.getResponseBodyAsString());

			Assert.assertEquals(Constants.responseHeaders,
					recUtil.getResponseContentType(request));
			Assert.assertEquals(Constants.statusCode, statusCode);
			jsonResult = (Map<Object, Object>) jsonResponse;
			Assert.assertNotNull("The object is null",
					(String) jsonResult.get("RSID"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}