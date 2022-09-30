package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_pojo_SerDes.EmpdetailsArray;

public class SerializationUsingArray {

	@Test
	
public void SerializationUsingArrayTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		int[] arr = {123,12345};
		
		//setp 1: create object of pojo class
		EmpdetailsArray e2 = new EmpdetailsArray(2, "Chaitra", arr, "Banglore");
		
		//step 2: create object of objectmapper to from jacksonmapper
		ObjectMapper obj = new ObjectMapper();
		
		//step 3: call write value method and provide file the file path
		obj.writeValue(new File("./SampleArray.json"), e2);
	
}
}