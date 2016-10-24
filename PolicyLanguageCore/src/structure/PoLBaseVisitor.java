// Generated from PoL.g4 by ANTLR 4.4

    package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;


public class PoLBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PoLVisitor<T> {
	
	private ArrayList<String> modules;
	private ArrayList<PoLClass> classes;
	public PoLClass currentClass;
	
	
	public PoLBaseVisitor()
	{
		modules = new ArrayList<String>();
		classes = new ArrayList<PoLClass>();
		
	}
	
	@Override public T visitSensitive_info(@NotNull PoLParser.Sensitive_infoContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitWhere_clause(@NotNull PoLParser.Where_clauseContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitSensitive_fields(@NotNull PoLParser.Sensitive_fieldsContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitConstraint_declaration(@NotNull PoLParser.Constraint_declarationContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitConstraint(@NotNull PoLParser.ConstraintContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitProg(@NotNull PoLParser.ProgContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitProgram_parts(@NotNull PoLParser.Program_partsContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitModule(@NotNull PoLParser.ModuleContext ctx) 
	{ 
		modules.add(ctx.getText());
		return visitChildren(ctx); 
	}
	
	@Override public T visitFields(@NotNull PoLParser.FieldsContext ctx) 
	{ 
		currentClass.addField(ctx.getText());
		return visitChildren(ctx); 
	}
	
	@Override public T visitClazz(@NotNull PoLParser.ClazzContext ctx) 
	{ 
		currentClass = new PoLClass();
		currentClass.setClassName(ctx.getText());
		classes.add(currentClass);
		return visitChildren(ctx); 
	}
	
	public ArrayList<String> getModules()
	{
		return modules;
	}
	
	public ArrayList<PoLClass> getClasses()
	{
		return classes;
	}
}