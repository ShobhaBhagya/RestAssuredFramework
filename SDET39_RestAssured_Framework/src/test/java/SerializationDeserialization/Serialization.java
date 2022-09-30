package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_pojo_SerDes.EmplyoeeDetails;

public class Serialization {

	@Test
	
	public void serializationTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		//setp 1: create object of pojo class
		EmplyoeeDetails emp = new EmplyoeeDetails("bhargavi", 1234567, "ty345", "bkr@gmail.com", true);
		
		//step 2: create object of objectmapper to from jacksonmapper
				ObjectMapper obj= new ObjectMapper();
		
		//step 3: call write value method and provide file the file path
		obj.writeValue(new File(".\\Emp.json"), emp);
	}
}
