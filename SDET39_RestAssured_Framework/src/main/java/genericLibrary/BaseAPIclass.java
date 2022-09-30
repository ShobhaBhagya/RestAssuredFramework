package genericLibrary;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class BaseAPIclass {
	
	public DataBaseLibrary dbLib = new DataBaseLibrary();
	public JavaUtility jlib = new JavaUtility();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		
		dbLib.connectToDB();
		Reporter.log("==DB Connection Successful==");
		
		baseURI = IConstantLibrary.appURL;
		port = IConstantLibrary.appPort;
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dbLib.closeDB();
		Reporter.log("==db closed==", true);
	}

}
