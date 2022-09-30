package DifferentWaysToPost;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
	
	@Test
	public void createProjectHashMap()
	{
		
		baseURI ="http://localhost";
		port = 8084;
		//create prerequisited
		 HashMap map = new HashMap();
		 map.put("createdBy", "sharvya");
		 map.put("projectName", "bang");
		 map.put("status", "On Going");
		 map.put("teamsize", 12);
		 
		 //send the request and validate the response
		 given()
		 .body(map)
		 .contentType(ContentType.JSON)
		 .when()
		  .post("/addProject")
		  .then()
		  .assertThat().statusCode(201).log().all();
	}

}
