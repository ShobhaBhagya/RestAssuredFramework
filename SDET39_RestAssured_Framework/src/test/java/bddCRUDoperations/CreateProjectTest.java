package bddCRUDoperations;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectTest {
	@Test
	public void CreateProject()
	{
	    
		Random ran= new Random();
		int random = ran.nextInt(500);
		baseURI ="http://localhost";
	    port=8084;
		//step 1: create the prerequisites neccessary
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Bhagya");
		obj.put("projectName", "xylem"+random);
		obj.put("status", "On Going");
		obj.put("teamsize", 10);
		
		//step 2: send the request
		given()
		 .body(obj)
		 .contentType(ContentType.JSON)
		.when()
		  .post("/addProject")
		.then()
		  .assertThat().statusCode(201)
		  .log().all();
		
 		
}}
