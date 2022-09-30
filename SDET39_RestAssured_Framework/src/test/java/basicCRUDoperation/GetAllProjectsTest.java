package basicCRUDoperation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {
	
	@Test
	public void getAllProject()
	{
		//step 1: create pre requisites
		
		// step 2: send the request
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		// step 3: validate the response
		int expStatus = 200;
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(actStatus, expStatus);
		//Assert.assertEquals(expStatus, actStatus);	
	}

}
