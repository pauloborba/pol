package unit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import production.PoLBuilder;

public class PolicyNumberTest {

	@Test
	public void test() {

		try
		{
			for(int j = 1; j <= 3; j++){
				int numberOfInputPolicies = 0;
				int numberOfOutputPolicies = 0;
				String policyInput = new Scanner(new File("test/sentences/sentences" + j + ".txt")).useDelimiter("\\Z").next();
				for(int i = 0; i < policyInput.length(); i++)
				{
					if(policyInput.charAt(i) == ';')
					{
						numberOfInputPolicies++;
					}
				}
				PoLBuilder.generateJSONFile("test/sentences/sentences" + j + ".txt");
				String policyOutput = new Scanner(new File("src/output.json")).useDelimiter("\\Z").next();
				for(int i = 0; i < policyOutput.length(); i++)
				{
					if(policyOutput.charAt(i) == ';')
					{
						numberOfOutputPolicies++;
					}
				}
				if(numberOfInputPolicies != numberOfOutputPolicies)
				{
					fail("The number of input and output policies doesn't match");
				}
			}

		}
		catch (FileNotFoundException e)
		{
			fail("File not found");
		} catch (IOException e) {
			fail("Error opening the file");
		}
	}

}
