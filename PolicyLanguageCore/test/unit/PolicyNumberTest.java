package unit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import production.PolicyBuilder;

public class PolicyNumberTest {

	@Test
	public void test() {

		for(int j = 1; j <= 3; j++){
			
			int numberOfInputPolicies = 0;
			int numberOfOutputPolicies = 0;
			String policyInput = "";
			String policyInputFilePath = "test/sentences/sentences" + j + ".txt";
			
			try 
			{
				policyInput = new Scanner(new File(policyInputFilePath)).useDelimiter("\\Z").next();
			} 
			catch (FileNotFoundException e1) 
			{
				fail("Could not find the file in the specified path " + policyInputFilePath);
			}
			
			for(int i = 0; i < policyInput.length(); i++)
			{
				if(policyInput.charAt(i) == ';')
				{
					numberOfInputPolicies++;
				}
			}
			
			String desiredOutputFilePath = "test/sentences/sentences" + j + ".txt";
			
			try 
			{
				PolicyBuilder.generateJSONPolicies(desiredOutputFilePath);
			} 
			catch (FileNotFoundException e) 
			{
				fail("Could not find the file in the specified path " + desiredOutputFilePath);
			} catch (IOException e) 
			{
				fail("The output file could not be created in the desired path, it's locked for writing or there's not enough space in the Hard Drive");
			}
			
			String policyOutput;
			try {
				policyOutput = new Scanner(new File("src/output.json")).useDelimiter("\\Z").next();
				for(int i = 0; i < policyOutput.length(); i++)
				{
					if(policyOutput.charAt(i) == ';')
					{
						numberOfOutputPolicies++;
					}
				}
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
