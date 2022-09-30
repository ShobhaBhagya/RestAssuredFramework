package authentications;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class bearerToken {
	
	@Test
	public void BearerToken()
	{
		baseURI="https://api.github.com";
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "SDET39-REST");
		jobj.put("description", "HybridFramework");
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		  .post("/user/repos")
		 .then()
		   .log().all();
		
		
	}

}
