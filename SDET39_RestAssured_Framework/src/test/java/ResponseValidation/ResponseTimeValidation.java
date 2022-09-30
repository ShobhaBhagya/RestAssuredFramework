package ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ResponseTimeValidation {
	
	@Test
	public void responseTime()
	{
		//create the prerequesites
		baseURI ="http://localhost";
		port=8084;
		//send the request 
		Response resp = when()
		.get("/project");
		
		System.out.println(resp.getTime());
	}

}
