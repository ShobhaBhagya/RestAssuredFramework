package ResponseValidation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	
	@Test
	public void staticResponse()
	{
		baseURI ="http://localhost";
		port=8084;
		//create the prerequesites
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "shravan");
		obj.put("projectName", "SDET39-ONLINE");
		obj.put("status", "On Going");
		obj.put("teamsize", 10);
		
		String expData ="SDET39-ONLINE";
		//send the request 
		Response resp = given()
		 .body(obj)
		 .contentType(ContentType.JSON)
		 .when()
		  .post("/addProject");
		//validate the response
		String actData = resp.jsonPath().get("");
		Assert.assertEquals(actData, expData);
		resp.then().log().all();
		
	}

}
