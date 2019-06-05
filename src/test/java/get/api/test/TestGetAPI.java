package get.api.test;


import org.sample.clientmethods.GetAPICalls;
import org.sample.utility.TestBase;
import org.testng.annotations.Test;

public class TestGetAPI extends TestBase{

	@Test
	public void getUsers() {
		String url=prp.getProperty("url")+prp.getProperty("api");
		GetAPICalls.getResponse(url);
		
	}
	@Test
	public void getUser() {
		String url=prp.getProperty("url")+prp.getProperty("api")+"/2";
		System.out.println("Response for one single user "+ GetAPICalls.getResponse(url));
		
	}
	@Test
	public void getUnknownUser() {
		String url=prp.getProperty("url")+prp.getProperty("api");
		System.out.println("Response for unknown user "+ GetAPICalls.getResponse(url));
		
	}
}
