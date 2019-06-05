package org.sample.clientmethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.sample.utility.FetchResponse;
import org.testng.collections.Objects.ToStringHelper;

public class GetAPICalls {

	public static CloseableHttpResponse response;

	public static List getResponse(String url) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			get.addHeader("content/type", "application/json");
			response = client.execute(get);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List l = FetchResponse.getResponse(response);
		return l;

	}
}
