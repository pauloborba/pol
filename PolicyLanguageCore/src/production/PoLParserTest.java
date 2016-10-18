package production;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import structure.PoLBaseVisitor;
import structure.PoLLexer;
import structure.PoLParser;
 
public class PoLParserTest
{
 
	public static void main(String[] args) throws Exception 
	{
	    try
	    {
	    	testParser();
	    }
	    catch(FileNotFoundException fnf)
	    {
	    	fnf.printStackTrace();
	    }
	}
	
	public static int testParser() throws FileNotFoundException
	{
		int numberOfErrors = 0;
		
		String content = new Scanner(new File("src/polExample.txt")).useDelimiter("\\Z").next();
	    System.out.println( "POL File:\n" + content + "\n\n");
	    
		ANTLRInputStream input = new ANTLRInputStream( content );
		
		PoLLexer lexer = new PoLLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		PoLParser parser = new PoLParser(tokens);
		
		parser.setBuildParseTree(true);
		
		RuleContext tree = parser.prog();
		
		tree.inspect(parser); 
		
		numberOfErrors = parser.getNumberOfSyntaxErrors();
		
		PoLBaseVisitor visit = new PoLBaseVisitor();
		
		visit.visit(tree);
			
		System.out.println(tree.toStringTree(parser));
		
		return numberOfErrors;
	}
	
 
}