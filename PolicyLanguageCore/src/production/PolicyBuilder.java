package production;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import structure.PoLBaseVisitor;
import structure.PoLLexer;
import structure.PoLParser;
import org.json.JSONObject;

//Main class that transforms a textual .pol file with policies from the pol language into a .json output 
public class PolicyBuilder {

	private static int numberOfErrors;
	private static PoLParser parser;
	private static PoLLexer lexer;
	private static RuleContext tree;
	private static PoLBaseVisitor visitor;

	public static void main(String[] args) {

		String inputFilePath = args[0];

		try 
		{
			generateJSONPolicies(inputFilePath);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("No file was found in " + inputFilePath);
		}
		catch (IOException e)
		{
			System.out.println("The output.json file could not be created, it's locked for writing or there's not enough space in the Hard Drive");
		}
	}

	public static int generateJSONPolicies(String inputFilepath) throws FileNotFoundException, IOException {

		String finalOutput = "";

		String inputPolicies = new Scanner(new File(inputFilepath)).useDelimiter("\\Z").next();

		visitTree(inputPolicies);

		ArrayList<JSONObject> policies = visitor.getPolicies();
		
		fromJSONStringsToTextFile(policies.toString());

		return numberOfErrors;
	}

	public static void fromJSONStringsToTextFile(String languageJsonOutput) throws IOException {

		File outputFile = new File("src/output.json");

		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		
		FileWriter filewriter = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
		bufferedWriter.write(languageJsonOutput);
		bufferedWriter.close();
	}

	
	public static void visitTree(String content) {
		ANTLRInputStream input = new ANTLRInputStream(content);

		lexer = new PoLLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		parser = new PoLParser(tokens);

		parser.setBuildParseTree(true);

		tree = parser.program();

		tree.inspect(parser);

		numberOfErrors = parser.getNumberOfSyntaxErrors();

		visitor = new PoLBaseVisitor();

		visitor.visit(tree);

	}

}