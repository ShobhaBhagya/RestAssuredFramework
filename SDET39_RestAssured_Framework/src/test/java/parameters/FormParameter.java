package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {
	
	@Test
	public void formparameter()
	{
		// create the prerequisite
		baseURI ="http://localhost";
		port=8084;
		//send the request and validate the response
		given()
		 .formParam( "createdBy", "shashank")
		 .formParam("projectName", "beacon")
		 .formParam("status", "Created")
		 .formParam("teamSize", "10")
		 .contentType(ContentType.JSON)
		 
		 .when()
		   .post("/addProject")
		   .then()
		   .log().all();
		 
	}

}
