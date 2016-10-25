package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import production.PoLBuilder;

public class JSONGenerationTest {

	@Test
	public void test() throws IOException {
		
		int numberOfErrors = 0;
		
		try 
		{
			numberOfErrors = PoLBuilder.generateJSONFile();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(numberOfErrors > 0){
			fail("Parsing errors occured");
		}
	}

}
