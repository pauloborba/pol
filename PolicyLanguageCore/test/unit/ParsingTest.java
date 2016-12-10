package unit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import production.PolicyBuilder;

public class ParsingTest {

	@Test
	public void test(){
		
		int numberOfErrors = 0;
		String inputFilePath = "test/parsingTestSentences/PoLSentences.txt";
		try 
		{
			numberOfErrors = PolicyBuilder.generateJSONPolicies(inputFilePath);
		} 
		catch (FileNotFoundException e) 
		{
			fail("File " + inputFilePath + " not found");
		}
		catch (IOException e)
		{
			fail("The output file could not be created in the desired path, it's locked for writing or there's not enough space in the Hard Drive");
		}
		if(numberOfErrors > 0){
			fail(numberOfErrors + " parsing errors occured");
		}
	}

}
