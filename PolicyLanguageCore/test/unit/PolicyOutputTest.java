package unit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import production.PoLBuilder;

public class PolicyOutputTest {
	@Test
	public void test() {

		try {
			for(int i = 1; i <= 2; i ++){
				PoLBuilder.generateJSONFile("test/sentences/inputSentence" + i + ".txt");
				String policyOutput = new Scanner(new File("src/output.json")).useDelimiter("\\Z").next().replace(" ", "").replace("\n", "").replace("\r", "");;
				System.out.println(policyOutput);
				String expectedOutput = new Scanner(new File("test/sentences/outputSentence" + i + ".txt")).useDelimiter("\\Z").next().replace(" ", "").replace("\n", "").replace("\r", "");
				System.out.println(expectedOutput);
				if(!policyOutput.equals(expectedOutput))
				{
					fail("The program output is not equal to the expected output");
				}
			}
		} catch (FileNotFoundException e) {
			fail("File not found");
		} catch (IOException e) {
			fail("Error opening the file");
		}
	}
}
