package DifferentWaysToPost;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONfile {
	
	@Test
	public void createProject()
	{
		baseURI="http://localhost";
		port=8084;
		//create Prerequisites
		File file= new File("./data.json");
		
		//send the request and validate the response
		given()
		 .body(file)
		 .contentType(ContentType.JSON)
		 .when()
		 .post("/addProject")
		 .then()
		 .log().all();
		 
	}

}
