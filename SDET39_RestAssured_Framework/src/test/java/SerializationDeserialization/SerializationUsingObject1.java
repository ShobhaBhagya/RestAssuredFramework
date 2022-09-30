package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_pojo_SerDes.EmpdetailsObject1;
import practice_pojo_SerDes.Spouse;

public class SerializationUsingObject1 {
    @Test
    
	public void SerializationUsingObject1Test() throws JsonGenerationException, JsonMappingException, IOException
	{
	int[] arr = {1234,12345};
	Spouse spouse = new Spouse("ABC", "intel", 63457);
	
	EmpdetailsObject1 emp3 = new EmpdetailsObject1(3, "bkr", arr, spouse, "banglore");
	
	ObjectMapper obj = new ObjectMapper();
	obj.writeValue(new File("./SampleObject1.json"), emp3);
	}
}
