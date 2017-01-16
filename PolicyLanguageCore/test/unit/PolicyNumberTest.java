package unit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import production.PolicyBuilder;

public class PolicyNumberTest {

	@Test
	public void test() {
		
		File folder = new File("test/numberOfPoliciesTestSentences/");
		File[] listOfFiles = folder.listFiles();
		
		for(int j = 0; j < listOfFiles.length ; j++){
			
			int numberOfInputPolicies = 0;
			int numberOfOutputPolicies = 0;
			String policyInput = "";
			String policyInputFilePath = listOfFiles[j].getPath();
			
			try 
			{
				policyInput = new Scanner(new File(policyInputFilePath)).useDelimiter("\\Z").next();
				numberOfInputPolicies = StringUtils.countMatches(policyInput, "noflow") + StringUtils.countMatches(policyInput, "noset");
				
			} 
			catch (FileNotFoundException e1) 
			{
				fail("Could not find the file in the specified path " + policyInputFilePath);
			}
			
			try 
			{
				PolicyBuilder.generateJSONPolicies(policyInputFilePath);
			} 
			catch (FileNotFoundException e) 
			{
				fail("Could not find the file in the specified path " + policyInputFilePath);
			} catch (IOException e) 
			{
				fail("The output file could not be created in the desired path, it's locked for writing or there's not enough space in the Hard Drive");
			}
			
			String policyOutput;
			try {
				policyOutput = new Scanner(new File("src/output.json")).useDelimiter("\\Z").next();
				numberOfOutputPolicies = StringUtils.countMatches(policyOutput, "noflow") + StringUtils.countMatches(policyOutput, "noset");
			} 
			catch (FileNotFoundException e) 
			{
				fail("Could not find src/output.json file");
			}
			
			if(numberOfInputPolicies != numberOfOutputPolicies)
			{
				fail("The number of input and output policies doesn't match");
			}
		}

	}

}
