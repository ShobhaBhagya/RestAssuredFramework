package bddCRUDoperations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectTest {
	
	      @Test
         public void getallProject()
         {
	    	  baseURI ="http://localhost";
	  	    port=8084;
	    	  //step 1: create the prerequisites neccessary
	  	//step 2: send the request
	  	    when()
	  	     .get("/projects")
	  	    .then()
	  	     .assertThat().statusCode(200)
	  	     .log().all(); 
	    	  
         }
}
