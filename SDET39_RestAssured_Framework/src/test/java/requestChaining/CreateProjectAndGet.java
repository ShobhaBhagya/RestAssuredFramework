package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import practice_pojo_SerDes.projectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectAndGet {

	@Test
	public void createandGet()
	{
		Random ran=new Random();
		//create pre requisite for Post
		baseURI ="http://localhost";
		port=8084;
		projectLibrary pLib = new projectLibrary("abcd", "bicycle"+ran.nextInt(100), "created", 8);
				//send the post request
		          Response resp = given()
		          .body(pLib)
		          .contentType(ContentType.JSON)
		          .when()
		          .post("/addProject");
				//capture the project ID writing json path
		         String projectID = resp.jsonPath().get("projectId");
		         System.out.println(projectID);
				//send the get request with projectID
		         when()
		          .get("/projects/"+projectID)
		         .then()
		          .assertThat().statusCode(200).log().all();
				
	}
}
