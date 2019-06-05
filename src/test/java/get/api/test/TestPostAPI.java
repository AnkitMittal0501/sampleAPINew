package get.api.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.json.JSONTokener;
import org.qa.data.Users;
import org.sample.clientmethods.PostAPICalls;
import org.sample.utility.FetchResponse;
import org.sample.utility.TestBase;
public class TestPostAPI extends TestBase {
	
	@Test
	public void callPostAPI() throws JsonGenerationException, JsonMappingException, IOException  {
		String url=prp.getProperty("url")+prp.getProperty("api");
		PostAPICalls client=new PostAPICalls();
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		//jackson API
		ObjectMapper obj=new ObjectMapper();
		Users user=new Users("ankit","leader");
		user.getJob();
		user.getName();
		//object to json 
		obj.writeValue(new File(System.getProperty("user.dir")+"/src/main/java/org/qa/data/user.json"), user);
		
		//PostAPICalls.getPostResponse(url,,headerMap);
		String userJsonString=obj.writeValueAsString(user);
		System.out.println(userJsonString);
		CloseableHttpResponse response=client.getPostResponse(url, userJsonString, headerMap);
		List l=FetchResponse.getResponse(response);
		System.out.println(l);
}
}
