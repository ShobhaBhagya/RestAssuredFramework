package bddCRUDoperations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	
	@Test
	public void deleteProject()
	{
	 
		baseURI = "http://localhost";
		port = 8084; 
		//step 1: create the prerequisites neccessary
		//step 2: send the request
		 when()
  	     .delete("/projects/TY_PROJ_2402")
  	    .then()
  	     .assertThat().statusCode(500)
  	     .log().all();
		//step 3: validate the response
	}

}
