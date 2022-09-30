package DifferentWaysToPost;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONobject {
	
	@Test
	public void createProject()
	{
		Random ran =new Random();
		int random=ran.nextInt(500);
		
		baseURI ="http://localhost";
		port=8084;
		//create the prerequesites
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "sanjana");
		obj.put("projectName", "jasmine"+random);
		obj.put("status", "On Going");
		obj.put("teamsize", 8);
		//send the request and validate the response
		given()
		 .body(obj)
		 .contentType(ContentType.JSON)
		 .when()
		  .post("/addProject")
		  .then()
		   .assertThat().statusCode(201)
		   .log().all();
	}

}
