// Generated from PoL.g4 by ANTLR 4.4

    package structure;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PoLParser}.
 */
public interface PoLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PoLParser#sensitive_info}.
	 * @param ctx the parse tree
	 */
	void enterSensitive_info(@NotNull PoLParser.Sensitive_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#sensitive_info}.
	 * @param ctx the parse tree
	 */
	void exitSensitive_info(@NotNull PoLParser.Sensitive_infoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(@NotNull PoLParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(@NotNull PoLParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#sensitive_fields}.
	 * @param ctx the parse tree
	 */
	void enterSensitive_fields(@NotNull PoLParser.Sensitive_fieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#sensitive_fields}.
	 * @param ctx the parse tree
	 */
	void exitSensitive_fields(@NotNull PoLParser.Sensitive_fieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(@NotNull PoLParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(@NotNull PoLParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#constraint_declaration}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_declaration(@NotNull PoLParser.Constraint_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#constraint_declaration}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_declaration(@NotNull PoLParser.Constraint_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(@NotNull PoLParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(@NotNull PoLParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(@NotNull PoLParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(@NotNull PoLParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#clazz}.
	 * @param ctx the parse tree
	 */
	void enterClazz(@NotNull PoLParser.ClazzContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#clazz}.
	 * @param ctx the parse tree
	 */
	void exitClazz(@NotNull PoLParser.ClazzContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull PoLParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull PoLParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PoLParser#program_parts}.
	 * @param ctx the parse tree
	 */
	void enterProgram_parts(@NotNull PoLParser.Program_partsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PoLParser#program_parts}.
	 * @param ctx the parse tree
	 */
	void exitProgram_parts(@NotNull PoLParser.Program_partsContext ctx);
}