//Visitor that stores the visited fields, classes and modules
package structure;

//Stores the modules and classes that were visited
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenStream;
//ANTLR visitor imports
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;


public class PoLBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PoLVisitor<T> {
	
	private PoLClass currentClass;
	private Policy currentPolicy;
	private ArrayList<Policy> policies;
	
	public PoLBaseVisitor()
	{
		policies = new ArrayList<Policy>();
	}
	
	@Override public T visitSensitive_info(@NotNull PoLParser.Sensitive_infoContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitWhere_clause(@NotNull PoLParser.Where_clauseContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitSensitive_fields(@NotNull PoLParser.Sensitive_fieldsContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitConstraint_declaration(@NotNull PoLParser.Constraint_declarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	//Starts a new Policy and add the construct to it
	@Override public T visitConstraint(@NotNull PoLParser.ConstraintContext ctx) { 
		currentPolicy = new Policy();
		String construct = ctx.getChild(1).getText();
		currentPolicy.setConstruct(construct);
		policies.add(currentPolicy);
		return visitChildren(ctx); 
	}
	
	@Override public T visitProg(@NotNull PoLParser.ProgContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitProgram_parts(@NotNull PoLParser.Program_partsContext ctx) 
	{ 
		List<ParseTree> modules = ctx.children;
		for(int i = 0; i < modules.size(); i++)
		{
			if(!modules.get(i).getText().equals(","))
			{
				currentPolicy.addModule(modules.get(i).getText());
			}
		}
		return visitChildren(ctx); 
	}
	
	//Add the modules to the current policy
	@Override public T visitModule(@NotNull PoLParser.ModuleContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	//Add the fields to the current class of the current policy
	@Override public T visitFields(@NotNull PoLParser.FieldsContext ctx) 
	{ 
		List<ParseTree> fields = ctx.children;
		for(int i = 0; i < fields.size(); i++)
		{
			if(!fields.get(i).getText().equals(","))
			{
				currentClass.addField(fields.get(i).getText());
			}
		}
		return visitChildren(ctx); 
	}
	
	//Add the class to the current policy
	@Override public T visitClazz(@NotNull PoLParser.ClazzContext ctx) 
	{ 
		currentClass = new PoLClass();
		currentClass.setClassName(ctx.getText());
		currentPolicy.addClass(currentClass);
		return visitChildren(ctx); 
	}
	
	public ArrayList<Policy> getPolicies()
	{
		return policies;
	}
	
}