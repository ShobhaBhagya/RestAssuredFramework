package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import practice_pojo_SerDes.projectLibrary;

public class CreateProjectUsingPojo {
	
	@Test
	public void createProject()
	{

		Random ran =new Random();
		int random=ran.nextInt(500);
		
		baseURI ="http://localhost";
		port=8084;
		
	
		//create the prerequesites
		projectLibrary pLib= new projectLibrary("shobha", "allstates"+random, "created", 10);
				
	   //send the request
				given()
				.body(pLib);
				
				
	}

}
