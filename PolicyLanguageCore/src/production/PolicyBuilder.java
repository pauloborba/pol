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
import structure.PoLClass;
import structure.PoLLexer;
import structure.PoLParser;
import structure.Policy;
import org.json.JSONArray;
import org.json.JSONException;
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

		ArrayList<Policy> policies = visitor.getPolicies();

		for (int i = 0; i < policies.size(); i++) {

			JSONObject currentPolicyJSONStructuringObject = new JSONObject();

			String currentPolicyJSONString = "";

			try {
				currentPolicyJSONString = fromPolicyToJSONString(currentPolicyJSONStructuringObject, policies.get(i));
				if(i < policies.size() - 1)
				{
					finalOutput += currentPolicyJSONString + ",";
				}
				else
				{
					finalOutput += currentPolicyJSONString;
				}
			} 
			catch (JSONException e) 
			{
				System.out.println("Your JSON file could not be parsed because of the following error: " + e.getMessage() );
			}

		}
		
		fromJSONStringsToTextFile(finalOutput);

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

	public static String fromPolicyToJSONString(JSONObject JSONStructuringObject, Policy policy) throws JSONException {

		buildPolicyModules(policy, JSONStructuringObject);

		buildPolicyClasses(policy, JSONStructuringObject);

		buildPolicyConstruct(policy, JSONStructuringObject);

		return JSONStructuringObject.toString();
	}

	public static void buildPolicyConstruct(Policy policy, JSONObject JSONStructuringObject) throws JSONException {
		String constructValue = "";

		if (policy.getConstruct().equals("noset")) {
			constructValue = "noset";
		} else {
			constructValue = "noflow";
		}

		JSONStructuringObject.put("construct", constructValue);
	}

	public static void buildPolicyModules(Policy policy, JSONObject JSONStructuringObject) throws JSONException {
		JSONObject identifiers = new JSONObject();
		JSONArray jsonModules = new JSONArray();
		ArrayList<String> modules = policy.getModules();
		for(int i = 0; i < modules.size(); i++)
		{
			jsonModules.put(modules.get(i));
		}
		identifiers.put("identifiers", jsonModules);
		JSONStructuringObject.put("module", identifiers );
	}

	public static void buildPolicyClasses(Policy policy, JSONObject JSONStructuringObject) throws JSONException {
		JSONArray JSONClasses = new JSONArray();

		ArrayList<PoLClass> visitorClasses = policy.getClazz();

		for (int i = 0; i < visitorClasses.size(); i++) {

			JSONObject currentJSONClass = new JSONObject();
			currentJSONClass.put("class-name", visitorClasses.get(i).getClassName());

			JSONArray JSONArrayOfFields = new JSONArray();
			ArrayList<String> fields = visitorClasses.get(i).getFields();

			buildPolicyFields(JSONArrayOfFields, currentJSONClass, fields);

			JSONClasses.put(currentJSONClass);
		}

		JSONStructuringObject.put("classes", JSONClasses);
	}


	public static void buildPolicyFields(JSONArray JSONArrayOfFields, JSONObject JSONClass, ArrayList<String> fields) throws JSONException {
		
		for (int j = 0; j < fields.size(); j++) {
			JSONArrayOfFields.put(fields.get(j));
		}

		JSONClass.put("fields", JSONArrayOfFields);
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