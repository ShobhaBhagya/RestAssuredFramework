package authentications;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class oauth2_0Authentication {
	
	@Test
	public void oauth2_0auth()
	{
		//step 1: generate the access token-post
		baseURI ="http://coop.apps.symfonycasts.com";
		
		Response resp = given()
		 .formParam("client_id", "Panchami")
		 .formParam("client_secret", "3b7281fa10b92f704e568a466a7f2ade")
		 .formParam("grant_type", "client_credentials")
		 .formParam("redirect_uri ", "http://example.com")
		 .formParam("code", "authorization_code")
		.when()
		  .post("/token");
		 
		//step 2: capture the access token
		  String token = resp.jsonPath().get("access_token");
		  System.out.println(token);
		
		//step 3: use it for other endpoints
		  given()
		    .pathParam("USER_ID", 3853)
		    .auth()
		    .oauth2(token)
		 .when()
		    .post("/api/{USER_ID}/chickens-feed")
		 .then().log().all();
		  
	}

}
