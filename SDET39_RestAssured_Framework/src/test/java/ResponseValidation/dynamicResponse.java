package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicResponse {
	
	@Test
	public void dynamic()
	{
		baseURI ="http://localhost";
		port=8084;
		//create the prerequisites
		String expData ="SDET39-ONLINE";
		
		// send the request
		Response resp = when()
		.get("/projects");
		
		//validate the response
		boolean flag=false;
		List<String> list = resp.jsonPath().get("projectId");
		for(String actData:list)
		{
			if(actData.equalsIgnoreCase(expData))
			{
				System.out.println(actData);
				flag=true; //flag rising
				break;
			}
		}
		
		Assert.assertTrue(flag);
		
	}

}
