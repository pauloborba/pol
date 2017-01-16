package structure;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override public T visitConstant_declaration(@NotNull PoLParser.Constant_declarationContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitWhere_clause(@NotNull PoLParser.Where_clauseContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitArgument(@NotNull PoLParser.ArgumentContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitContribution_expression(@NotNull PoLParser.Contribution_expressionContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitModule(@NotNull PoLParser.ModuleContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitConstraint_declaration(@NotNull PoLParser.Constraint_declarationContext ctx) 
	{ 
		currentPolicy = new Policy();
		String construct = ctx.getChild(1).getText();
		currentPolicy.setConstruct(construct);
		policies.add(currentPolicy);
		return visitChildren(ctx); 
	}
	
	@Override public T visitProgram(@NotNull PoLParser.ProgramContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitContribution_spec(@NotNull PoLParser.Contribution_specContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitProgram_parts(@NotNull PoLParser.Program_partsContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitCommit_hash(@NotNull PoLParser.Commit_hashContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitSensitive_info(@NotNull PoLParser.Sensitive_infoContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitMethod_call(@NotNull PoLParser.Method_callContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitFull_name(@NotNull PoLParser.Full_nameContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitSingle_method_call(@NotNull PoLParser.Single_method_callContext ctx) 
	{ 
		currentPolicy.addModule(ctx.getText());
		currentPolicy.setPolicyType("method_set");
		return visitChildren(ctx); 
	}
	
	@Override public T visitSensitive_fields(@NotNull PoLParser.Sensitive_fieldsContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitContribution_id(@NotNull PoLParser.Contribution_idContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitArgument_list(@NotNull PoLParser.Argument_listContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitAuthor_id(@NotNull PoLParser.Author_idContext ctx) { return visitChildren(ctx); }
	
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
	
	@Override public T visitClazz(@NotNull PoLParser.ClazzContext ctx) {
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