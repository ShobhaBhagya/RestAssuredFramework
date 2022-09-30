package basicCRUDoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
	public void UpdateProject()
	{
		//step 1: create the prerequisites necessary
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Bhargavi");
		obj.put("projectName", "SDET123");
		obj.put("status", "Completed");
		obj.put("teamsize", 12);
		
		// step 2: send the request
        RequestSpecification request = RestAssured.given();
		
		request.body(obj);
		request.contentType(ContentType.JSON);
		
		 Response resp = request.put("http://localhost:8084/projects/TY_PROJ_1803");
		 
		// step 3: validate the response
		 System.out.println(resp.getStatusCode());
		 
	}

}
