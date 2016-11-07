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

//JSON object manipulation
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
public class PoLBuilder
{
 
	private static int numberOfErrors;
	private static PoLParser parser;
	private static PoLLexer lexer;
	private static RuleContext tree;
	private static PoLBaseVisitor visit;
	
	public static void main(String[] args) throws Exception 
	{
	    try
	    {
	    	generateJSONFile();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public static int generateJSONFile() throws FileNotFoundException, IOException
	{
		
		String languageInputContent = new Scanner(new File("PoLSentences.txt")).useDelimiter("\\Z").next();
	    
		System.out.println( "POL File:\n" + languageInputContent + "\n\n");
	    
		visitTree(languageInputContent);
	
		JSONObject JSONStructuringObject = new JSONObject();
		
		String languageJsonOutput = "";
		
		try 
		{
			languageJsonOutput = JSONBuilder(JSONStructuringObject, languageInputContent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		generateTextFile(languageJsonOutput);
		
		System.out.println(tree.toStringTree(parser));
		
		return numberOfErrors;
	}
	
	public static void generateTextFile(String languageJsonOutput) throws IOException
	{
		File outputFile = new File("src/output.txt");

		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		FileWriter filewriter = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
		bufferedWriter.write(languageJsonOutput);
		bufferedWriter.close();
	}
	
	public static void buildContent(String inputContent, JSONObject JSONStructuringObject) throws JSONException
	{
		String constructValue = "";
		
		if(inputContent.contains("noset"))
		{
			constructValue = "noset";
		}
		else
		{
			constructValue = "noflow";
		}
		
		JSONStructuringObject.put("construct", constructValue);
	}
	
	public static void buildModules(JSONObject JSONStructuringObject) throws JSONException
	{
		JSONStructuringObject.put("module", visit.getModules().toArray());
	}
	
	public static void buildFields(JSONArray JSONArrayOfFields, JSONObject JSONClass, ArrayList<String> fields) throws JSONException
	{
		for(int j = 0; j < fields.size(); j++)
		{
			JSONArrayOfFields.put(fields.get(j));
		}

		JSONClass.put("fields", JSONArrayOfFields);
	}
	
	public static void buildClasses(JSONObject JSONStructuringObject) throws JSONException
	{
		JSONArray JSONClasses = new JSONArray();

		ArrayList<PoLClass> visitorClasses = visit.getClasses();

		for(int i = 0; i < visitorClasses.size(); i++)
		{
			JSONObject currentJSONClass = new JSONObject();
			currentJSONClass.put("class-name", visitorClasses.get(i).getClassName());

			JSONArray JSONArrayOfFields = new JSONArray();
			ArrayList<String> fields = visitorClasses.get(i).getFields();

			buildFields(JSONArrayOfFields, currentJSONClass, fields);

			JSONClasses.put(currentJSONClass);
		}

		JSONStructuringObject.put("classes", JSONClasses);
	}
	
	public static String JSONBuilder(JSONObject JSONStructuringObject, String content) throws JSONException
	{
		
		buildModules(JSONStructuringObject);
		
		buildContent(content,JSONStructuringObject);
		
		buildClasses(JSONStructuringObject);
		
		return JSONStructuringObject.toString();
	}
	
	public static void visitTree(String content)
	{
		ANTLRInputStream input = new ANTLRInputStream( content );
		
		lexer = new PoLLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		parser = new PoLParser(tokens);
		
		parser.setBuildParseTree(true);
		
		tree = parser.prog();
		
		tree.inspect(parser); 
		
		numberOfErrors = parser.getNumberOfSyntaxErrors();
		
		visit = new PoLBaseVisitor();
		
		visit.visit(tree);
		
	}
	
 
}