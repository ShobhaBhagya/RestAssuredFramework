package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import practice_pojo_SerDes.projectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateUpdateGetDelete {
	
	@Test
	public void cretaeUpdateGetDelete()
	{
		Random ran=new Random();
		//create pre requisite for Post
		baseURI ="http://localhost";
		port=8084;
		projectLibrary pLib = new projectLibrary("hasini", "sun"+ran.nextInt(100), "Created", 12);
				
		//send the post request
		          Response resp = given()
		          .body(pLib)
		          .contentType(ContentType.JSON)
		          .when()
		          .post("/addProject");
				
		          //capture the project ID writing json path
		         String projectID = resp.jsonPath().get("projectId");
		         System.out.println(projectID);
		         
		       //send the update request with projectID
		         given()
		         .pathParam("pid", projectID)
		         .when()
		          .put("/projects/{pid}");
		         
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
