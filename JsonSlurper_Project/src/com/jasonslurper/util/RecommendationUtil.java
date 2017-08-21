package com.jasonslurper.util;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.methods.GetMethod;

public class RecommendationUtil {
	
	Properties prop = new Properties();
	public Header[] header = null;
	

	public void getProperties(String fileName) {
		try {
			prop.load(new FileInputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getResponseHeader(GetMethod request) {
		header = request.getResponseHeaders();
	}
	
	public String getResponseContentType(GetMethod request) {
		header = request.getResponseHeaders();
		return header[0].getValue();
	}
}

