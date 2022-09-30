package authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class basicAuthentication {
	
	@Test
	public void BasicAuth()
	{
	     baseURI = "http://localhost";
	     port = 8084;
	     given()
	     .auth()
	     .basic("rmgyantra", "rmgy@9999")
	     .when()
	     .get("/login")
	     .then()
	     .log().all();
	}
	
	@Test
	public void digestiveAuthentication()
	{
		baseURI = "http://localhost";
	     port = 8084;
	     given()
	     .auth()
	     .digest("rmgyantra", "rmgy@9999")
	     .when()
	     .get("/login")
	     .then().log().all();
	}
    
	@Test
	public void preemptiveAuth()
	{
		baseURI = "http://localhost";
	     port = 8084;
	     given()
	     .auth()
	     .preemptive().basic("rmgyantra", "rmgy@9999")
	     .when()
	     .get("/login")
	     .then().log().all();
	}
}
