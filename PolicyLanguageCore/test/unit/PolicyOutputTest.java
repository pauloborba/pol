package unit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import production.PolicyBuilder;

public class PolicyOutputTest {
	@Test
	public void test() {
		for(int i = 1; i <= 2; i ++){

			String inputSentenceFilePath = "test/sentences/inputSentence" + i + ".txt";

			try 
			{
				PolicyBuilder.generateJSONPolicies(inputSentenceFilePath);
			} 
			catch (FileNotFoundException e) 
			{
				fail("Could not find the input sentence file in the specified path " + inputSentenceFilePath);
			} 
			catch (IOException e) 
			{
				fail("The output file could not be created in the desired path, it's locked for writing or there's not enough space in the Hard Drive");
			}

			String policyOutput = "";
			String policyOutputFilePath = "src/output.json";
			try 
			{
				policyOutput = new Scanner(new File(policyOutputFilePath)).useDelimiter("\\Z").next().replace(" ", "").replace("\n", "").replace("\r", "");
			} 
			catch (FileNotFoundException e) 
			{
				fail("Could not find the output file in the specified path " + policyOutputFilePath);
			};

			String expectedOutput = "";
			String expectedOutputFilePath = "test/sentences/outputSentence" + i + ".txt";
			try 
			{
				expectedOutput = new Scanner(new File(expectedOutputFilePath)).useDelimiter("\\Z").next().replace(" ", "").replace("\n", "").replace("\r", "");
			} 
			catch (FileNotFoundException e) 
			{
				fail("Could not find the expected output file in the specified path " + expectedOutputFilePath);
			}

			if(!policyOutput.equals(expectedOutput))
			{
				fail("The program output is not equal to the expected output");
			}
		}
	}
}
