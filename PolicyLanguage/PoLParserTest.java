import java.util.Scanner;
 
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
 
public class PoLParserTest
{
 
	public static void main(String[] args) throws Exception 
	{
	    String content = new Scanner(new File("target/generated-sources/antlr4/polExample.txt")).useDelimiter("\\Z").next();
	    System.out.println( "JSON File:\n" + content + "\n\n");
	    
		ANTLRInputStream input = new ANTLRInputStream( content );
		
		PoLLexer lexer = new PoLLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		PoLParser parser = new PoLParser(tokens);
		
		ParseTree tree = parser.json();
		
		System.out.println( "ParseTree:\n" + tree.toStringTree( parser ) + "\n"); 
	}
 
}