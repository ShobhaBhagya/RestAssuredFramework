package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import practice_pojo_SerDes.projectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectAndGetAndDelete {
	
	@Test
	public void createGetDelete()
	{
		Random ran=new Random();
		//create pre requisite for Post
		baseURI ="http://localhost";
		port=8084;
		projectLibrary pLib = new projectLibrary("hasani", "electroide"+ran.nextInt(100), "On Going", 10);
				
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
		         given()
		         .pathParam("pid", projectID)
		         .when()
		          .get("/projects/{pid}")
		         .then()
		          .assertThat().statusCode(200).log().all();
		         
		         when()
		         .delete("/projects/"+projectID)
		        //System.out.println(resp1.getStatusCode());
		         .then()
		         .assertThat().statusCode(204).log().all();
	}

}
