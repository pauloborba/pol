package structure;

import java.util.ArrayList;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//Visitor that builds the JSON output from the input policies
public class PoLBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PoLVisitor<T> {

	private ArrayList<JSONObject> policiesOutput;
	private JSONObject currentPolicy;
	private JSONObject currentClass;
	private JSONArray  currentClassesArray;
	private JSONObject currentModule;
	private JSONArray  currentModulesArray;

	public PoLBaseVisitor()
	{
		policiesOutput = new ArrayList<JSONObject>();
	}

	@Override public T visitConstraint_declaration(@NotNull PoLParser.Constraint_declarationContext ctx) 
	{ 
		try
		{
			currentPolicy = new JSONObject();
			currentModulesArray = new JSONArray();
			currentClassesArray = new JSONArray();
			currentPolicy.put("classes", currentClassesArray);
			currentPolicy.put("modules", currentModulesArray);

			String construct_type = ctx.getChild(1).getText();
			currentPolicy.put("construct", construct_type );

			policiesOutput.add(currentPolicy);
		}
		catch(JSONException e)
		{
			throw new RuntimeException(e);
		}

		return visitChildren(ctx); 
	}

	@Override public T visitModule(@NotNull PoLParser.ModuleContext ctx) 
	{ 
		try
		{
			if(ctx.ID() == null  && ctx.program_parts().contribution_expression() == null )
			{
				if(ctx.program_parts().commit_hash() != null)
				{
					currentModule = new JSONObject();
					String [] commitHashes = ctx.getText().replaceAll("(\")|(\\{)|(\\})", "").split(",");
					currentModule.put("identifiers", new JSONArray(commitHashes));
					currentModulesArray.put(currentModule);

				}
				else if (ctx.program_parts().single_method_call() != null )
				{
					currentModule = new JSONObject();
					String [] methodNames = ctx.getText().split(",");
					currentModule.put("identifiers", methodNames);
					currentModulesArray.put(currentModule);
				}
			}
		} 
		catch(JSONException e)
		{
			throw new RuntimeException(e);
		}
		return visitChildren(ctx); 
	}

	@Override public T visitContribution_spec(@NotNull PoLParser.Contribution_specContext ctx) 
	{ 
		try 
		{
			currentModule = new JSONObject();
			String contributionSpecification = ctx.getText();
			String method = contributionSpecification.substring(contributionSpecification.indexOf('.') + 1, contributionSpecification.indexOf('('));
			String identifier = contributionSpecification.substring(0, contributionSpecification.indexOf("."));
			currentModule.put("method", method);
			currentModule.put("identifier", identifier);
			currentModulesArray.put(currentModule);
		} 
		catch (JSONException e) 
		{
			throw new RuntimeException(e);
		}
		return visitChildren(ctx); 
	}

	@Override public T visitArgument_list(@NotNull PoLParser.Argument_listContext ctx) 
	{
		try 
		{
			String [] argumentsArray = ctx.getText().replaceAll("\"", "").split(",");
			currentModule.put("arguments", new JSONArray(argumentsArray));
		} 
		catch (JSONException e) 
		{
			 throw new RuntimeException(e);
		}
		return visitChildren(ctx); 
	}

	@Override public T visitClazz(@NotNull PoLParser.ClazzContext ctx) 
	{
		currentClass = new JSONObject();
		try 
		{
			currentClass.put("class-name", ctx.getText());
			currentClassesArray.put(currentClass);
		} 
		catch (JSONException e) 
		{
			 throw new RuntimeException(e);
		}

		return visitChildren(ctx); 
	}

	@Override public T visitFields(@NotNull PoLParser.FieldsContext ctx) 
	{ 
		try 
		{
			String [] fieldsArray = ctx.getText().replaceAll("\"", "").split(",");
			currentClass.put("fields", fieldsArray);
		} 
		catch (JSONException e)
		{
			 throw new RuntimeException(e);
		}
		return visitChildren(ctx); 
	}

	@Override public T visitCommit_hash(@NotNull PoLParser.Commit_hashContext ctx) { return visitChildren(ctx);}

	@Override public T visitConstant_declaration(@NotNull PoLParser.Constant_declarationContext ctx) { return visitChildren(ctx); }

	@Override public T visitWhere_clause(@NotNull PoLParser.Where_clauseContext ctx) { return visitChildren(ctx); }

	@Override public T visitArgument(@NotNull PoLParser.ArgumentContext ctx) { return visitChildren(ctx); }

	@Override public T visitContribution_expression(@NotNull PoLParser.Contribution_expressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitProgram(@NotNull PoLParser.ProgramContext ctx) { return visitChildren(ctx); }

	@Override public T visitProgram_parts(@NotNull PoLParser.Program_partsContext ctx) { return visitChildren(ctx); }

	@Override public T visitSensitive_info(@NotNull PoLParser.Sensitive_infoContext ctx) { return visitChildren(ctx); }

	@Override public T visitMethod_call(@NotNull PoLParser.Method_callContext ctx) { return visitChildren(ctx); }

	@Override public T visitFull_name(@NotNull PoLParser.Full_nameContext ctx) { return visitChildren(ctx); }

	@Override public T visitSingle_method_call(@NotNull PoLParser.Single_method_callContext ctx) { return visitChildren(ctx); }

	@Override public T visitSensitive_fields(@NotNull PoLParser.Sensitive_fieldsContext ctx) { return visitChildren(ctx); }

	@Override public T visitContribution_id(@NotNull PoLParser.Contribution_idContext ctx) { return visitChildren(ctx); }

	@Override public T visitAuthor_id(@NotNull PoLParser.Author_idContext ctx) { return visitChildren(ctx); }

	public ArrayList<JSONObject> getPolicies()
	{
		return policiesOutput;
	}

}