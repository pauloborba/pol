package unit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import production.PolicyBuilder;

public class ParsingTest {

	@Test
	public void test() throws IOException {
		
		int numberOfErrors = 0;
		String inputFilePath = "test/sentences/PoLSentences.txt";
		try 
		{
			numberOfErrors = PolicyBuilder.generateJSONPolicies(inputFilePath);
		} 
		catch (FileNotFoundException e) 
		{
			fail("File " + inputFilePath + " not found");
		}
		if(numberOfErrors > 0){
			fail(numberOfErrors + " parsing errors occured");
		}
	}

}
