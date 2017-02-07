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
		
		File inputFolder = new File("test/policyInputs/");
		File[] listOfInputFiles = inputFolder.listFiles();
		
		File expectedOutputFolder = new File("test/expectedPolicyOutputs/");
		File[] listOfExpectedOutputFiles = expectedOutputFolder.listFiles();
		
		for(int i = 0; i < listOfInputFiles.length; i ++){

			try 
			{
				PolicyBuilder.generateJSONPolicies(listOfInputFiles[i].getPath());
			} 
			catch (FileNotFoundException e) 
			{
				fail("Could not find the input sentence file in the specified path " + listOfInputFiles[i].getPath());
			} 
			catch (IOException e) 
			{
				fail("The output file could not be created in the desired path, it's locked for writing or there's not enough space in the Hard Drive");
			} 
			

			String policyOutput = null;
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
			try 
			{
				expectedOutput = new Scanner(new File(listOfExpectedOutputFiles[i].getPath())).useDelimiter("\\Z").next().replace(" ", "").replace("\n", "").replace("\r", "");
			} 
			catch (FileNotFoundException e) 
			{
				fail("Could not find the expected output file in the specified path " + listOfExpectedOutputFiles[i].getPath());
			}

			if(!policyOutput.equals(expectedOutput))
			{
				fail("The program output is not equal to the expected output");
			}
		}
	}
}
