package production;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import structure.PoLBaseVisitor;
import structure.PoLClass;
import structure.PoLLexer;
import structure.PoLParser;
 
public class PoLParserTest
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
		
		String languageInputContent = new Scanner(new File("src/polExample.txt")).useDelimiter("\\Z").next();
	    
		System.out.println( "POL File:\n" + languageInputContent + "\n\n");
	    
		parserSetup(languageInputContent);
	
		JSONObject JSONStructuringObject = new JSONObject();
		
		String languageJsonOutput = "";
		
		try 
		{
			languageJsonOutput = JSONBuilder(JSONStructuringObject, languageInputContent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		File outputFile = new File("src/output.txt");
		
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		FileWriter filewriter = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
		bufferedWriter.write(languageJsonOutput);
		bufferedWriter.close();
		
		System.out.println(tree.toStringTree(parser));
		
		return numberOfErrors;
	}
	
	public static String JSONBuilder(JSONObject JSONStructuringObject, String content) throws JSONException
	{
		
		Object[] modules = visit.getModules().toArray();
		JSONStructuringObject.put("module", modules);
		
		String constructValue = "";
		
		if(content.contains("noset"))
		{
			constructValue = "noset";
		}
		else
		{
			constructValue = "noflow";
		}
		
		JSONStructuringObject.put("construct", constructValue);
		
		JSONArray JSONClasses = new JSONArray();
		
		ArrayList<PoLClass> visitorClasses = visit.getClasses();
		
		for(int i = 0; i < visitorClasses.size(); i++)
		{
			JSONObject currentJSONClass = new JSONObject();
			currentJSONClass.put("class-name", visitorClasses.get(i).getClassName());
			
			JSONArray JSONArrayOfFields = new JSONArray();
			ArrayList<String> fields = visitorClasses.get(i).getFields();
			
			for(int j = 0; j < fields.size(); j++)
			{
				JSONArrayOfFields.put(fields.get(j));
			}
			
			currentJSONClass.put("fields", JSONArrayOfFields);
			
			JSONClasses.put(currentJSONClass);
		}
		
		JSONStructuringObject.put("classes", JSONClasses);
		
		return JSONStructuringObject.toString();
	}
	
	public static void parserSetup(String content)
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