package basicCRUDoperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {
	
	@Test
	public void DeleteProject()
	{
		//step 1: create the prerequisites necessary
		
		// step 2: send the request
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1803");
		
		// step 3: validate the response
		System.out.println(resp.getStatusCode());
	}
}
