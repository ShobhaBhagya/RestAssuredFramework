package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameter {
	
	@Test
	public void pathparameter()
	{
	// create the prerequisite
		baseURI ="http://localhost";
		port=8084;
	//send the request
		given()
		 .pathParam("pid", "TY_PROJ_2611")
		 .when()
		 .delete("/projects/{pid}")
		 .then()
		 .assertThat().statusCode(204).log().all();
	}

}
