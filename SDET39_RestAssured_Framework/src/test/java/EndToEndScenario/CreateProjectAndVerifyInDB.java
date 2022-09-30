package EndToEndScenario;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIclass;
import genericLibrary.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import practice_pojo_SerDes.projectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectAndVerifyInDB extends BaseAPIclass {
	
	@Test
	public void createProject() throws SQLException
	{
		// Create Prerequisites
		
		projectLibrary pojo = new projectLibrary("Bhargavi", "STAR" + jlib.getRandomNumber(), "Created", 12);
		
		//send the post request
		
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(pojo)
				.when()
				.post(EndPointsLibrary.createProject);
		
		//capture the project id
		
		String expData = rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		//verify the projectId in DB
		
		String query = "Select * from project";
		String actualData = dbLib.executeQueryAndReturnData(query, 1, expData);
		Assert.assertEquals(actualData, expData);
		
	}

}
