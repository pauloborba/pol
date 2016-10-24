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
		
		String content = new Scanner(new File("src/polExample.txt")).useDelimiter("\\Z").next();
	    
		System.out.println( "POL File:\n" + content + "\n\n");
	    
		setupParser(content);
	
		JSONObject output = new JSONObject();
		
		String JSONResult = "";
		
		try 
		{
			JSONResult = JSONBuilder(output, content);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		File file = new File("src/output.txt");
		
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(JSONResult);
		bw.close();
		
		System.out.println(tree.toStringTree(parser));
		
		return numberOfErrors;
	}
	
	public static String JSONBuilder(JSONObject output, String content) throws JSONException
	{
		
		Object[] modules = visit.getModules().toArray();
		output.put("module", modules);
		
		
		String constructValue = "";
		
		if(content.contains("noset"))
		{
			constructValue = "noset";
		}
		else
		{
			constructValue = "noflow";
		}
		
		output.put("construct", constructValue);
		
		JSONArray JSONClasses = new JSONArray();
		
		ArrayList<PoLClass> classes = visit.getClasses();
		
		for(int i = 0; i < classes.size(); i++)
		{
			JSONObject currentClass = new JSONObject();
			currentClass.put("class-name", classes.get(i).getClassName());
			
			JSONArray JSONFieldsArray = new JSONArray();
			ArrayList<String> fields = classes.get(i).getFields();
			
			for(int j = 0; j < fields.size(); j++)
			{
				JSONFieldsArray.put(fields.get(j));
			}
			currentClass.put("fields", JSONFieldsArray);
			
			JSONClasses.put(currentClass);
		}
		
		output.put("classes", JSONClasses);
		
		return output.toString();
	}
	
	public static void setupParser(String content)
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