//Generator for the JSON .txt output

package production;

//Creation of .txt output file.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

//To store the fields, classes and modules
import java.util.ArrayList;
import java.util.Scanner;

//ANTLR parsing and visitor classes
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import structure.PoLBaseVisitor;
import structure.PoLClass;
import structure.PoLLexer;
import structure.PoLParser;
import structure.Policy;

//JSON object manipulation
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoLBuilder {

	private static int numberOfErrors;
	private static PoLParser parser;
	private static PoLLexer lexer;
	private static RuleContext tree;
	private static PoLBaseVisitor visitor;
	private static String finalOutput;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Paste the file path below and press enter");
		String filepath = in.nextLine();
		try {
			generateJSONFile(filepath);
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	// Build and creates the JSON output file
	public static int generateJSONFile(String filepath) throws FileNotFoundException, IOException {
		finalOutput = "";

		String languageInputContent = new Scanner(new File(filepath)).useDelimiter("\\Z").next();

		System.out.println("POL File:\n" + languageInputContent + "\n\n");

		visitTree(languageInputContent);

		ArrayList<Policy> policies = visitor.getPolicies();

		for (int i = 0; i < policies.size(); i++) {

			JSONObject JSONStructuringObject = new JSONObject();

			String currentPolicyOutput = "";

			try {
				currentPolicyOutput = JSONBuilder(JSONStructuringObject, policies.get(i));
				finalOutput += currentPolicyOutput + ";";
			} catch (JSONException e) {
				System.out.println("Your JSON file is invalid :(");
			}

		}

		generateTextFile(finalOutput);

		System.out.println(tree.toStringTree(parser));

		return numberOfErrors;
	}

	// Creates the .txt file with the JSON output
	public static void generateTextFile(String languageJsonOutput) throws IOException {
		File outputFile = new File("src/output.json");

		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		FileWriter filewriter = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
		bufferedWriter.write(languageJsonOutput);
		bufferedWriter.close();
	}

	// Builds the JSON object that will be written in the txt file
	public static String JSONBuilder(JSONObject JSONStructuringObject, Policy policy) throws JSONException {

		buildModules(policy, JSONStructuringObject);

		buildClasses(policy, JSONStructuringObject);
		
		buildConstruct(policy, JSONStructuringObject);

		return JSONStructuringObject.toString();
	}

	// Builds the JSON construct objects
	public static void buildConstruct(Policy policy, JSONObject JSONStructuringObject) throws JSONException {
		String constructValue = "";

		if (policy.getConstruct().equals("noset")) {
			constructValue = "noset";
		} else {
			constructValue = "noflow";
		}

		JSONStructuringObject.put("construct", constructValue);
	}

	// Builds the JSON module objects
	public static void buildModules(Policy policy, JSONObject JSONStructuringObject) throws JSONException {
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

	// Builds the JSON field objects
	public static void buildFields(JSONArray JSONArrayOfFields, JSONObject JSONClass, ArrayList<String> fields)
			throws JSONException {
		for (int j = 0; j < fields.size(); j++) {
			JSONArrayOfFields.put(fields.get(j));
		}

		JSONClass.put("fields", JSONArrayOfFields);
	}

	// Builds the JSON class objects
	public static void buildClasses(Policy policy, JSONObject JSONStructuringObject) throws JSONException {
		JSONArray JSONClasses = new JSONArray();

		ArrayList<PoLClass> visitorClasses = policy.getClazz();

		for (int i = 0; i < visitorClasses.size(); i++) {
			JSONObject currentJSONClass = new JSONObject();
			currentJSONClass.put("class-name", visitorClasses.get(i).getClassName());

			JSONArray JSONArrayOfFields = new JSONArray();
			ArrayList<String> fields = visitorClasses.get(i).getFields();

			buildFields(JSONArrayOfFields, currentJSONClass, fields);

			JSONClasses.put(currentJSONClass);
		}

		JSONStructuringObject.put("classes", JSONClasses);
	}

	// Initialize the parser and build the syntax tree
	public static void visitTree(String content) {
		ANTLRInputStream input = new ANTLRInputStream(content);

		lexer = new PoLLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		parser = new PoLParser(tokens);

		parser.setBuildParseTree(true);

		tree = parser.prog();

		tree.inspect(parser);

		numberOfErrors = parser.getNumberOfSyntaxErrors();

		visitor = new PoLBaseVisitor();

		visitor.visit(tree);

	}

}