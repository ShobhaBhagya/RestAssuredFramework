package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameter {
	
	@Test
	public void queryparameter()
	{
		// create the prerequisite
		baseURI ="https://reqres.in";
		//send the request and validate the response
		given()
		.queryParam("page", 3)
		.when()
		 .get("/api/users")
		 .then()
		 .assertThat().statusCode(200).log().all();
	}

}
