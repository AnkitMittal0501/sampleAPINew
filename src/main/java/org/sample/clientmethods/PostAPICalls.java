package org.sample.clientmethods;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class PostAPICalls {
	public CloseableHttpResponse response;

	public CloseableHttpResponse getPostResponse(String url, String entityString, HashMap<String,String> headerMap) {
		try {
		CloseableHttpClient client = 	HttpClients.createDefault();
		HttpPost post=new HttpPost(url);
		post.setEntity(new StringEntity(entityString));
		for(Map.Entry<String,String> entry: headerMap.entrySet())
		{
			post.addHeader(entry.getKey(), entry.getValue());
		}
			 response=client.execute(post);
		}
		catch(Exception e) {
			
		}
		return response;
		
	}
}
