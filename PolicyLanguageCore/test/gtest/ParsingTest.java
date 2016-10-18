package gtest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import production.PoLParserTest;

public class ParsingTest {

	@Test
	public void test() {
		
		int numberOfErrors = 0;
		
		try 
		{
			numberOfErrors = PoLParserTest.testParser();
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
