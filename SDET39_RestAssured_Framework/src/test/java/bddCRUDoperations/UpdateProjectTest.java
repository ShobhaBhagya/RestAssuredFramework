package bddCRUDoperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateProjectTest {

	@Test
	public void updateProject()
	{
		Random ran= new Random();
		int random = ran.nextInt(500);
		baseURI="http://localhost";
		port=8084;
		//step 1: create the prerequisites neccessary
				JSONObject obj = new JSONObject();
				obj.put("createdBy", "Bhagya");
				obj.put("projectName", "xylem"+random);
				obj.put("status", "Completed");
				obj.put("teamsize", 12);
				
	    //step 2: send the request
				given()
				.body(obj)
				.contentType(ContentType.JSON)
			   .when()
			     .put("/projects/TY_PROJ_2202")
			     .then()
			     .assertThat().statusCode(200)
		  	     .log().all(); 
						
				
	}
}
