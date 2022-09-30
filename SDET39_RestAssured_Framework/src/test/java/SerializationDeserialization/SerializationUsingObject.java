package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_pojo_SerDes.EmpdetailsObject;

public class SerializationUsingObject {
	
	@Test
	
	public void SerializationUsingObjectTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		int[] arr = {1234,12345};
		String[] emailid= {"bkr@gmail.com", "smg123@gmail.com", "abcd@gmai.com"}; 
		
		
		EmpdetailsObject e3 = new EmpdetailsObject(3, "bhargavi", arr, emailid, "banglore");
		
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("./SampleObject.json"), e3);
	}

}
