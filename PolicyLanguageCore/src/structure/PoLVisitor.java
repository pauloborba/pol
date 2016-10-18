// Generated from PoL.g4 by ANTLR 4.4

    package structure;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PoLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PoLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PoLParser#sensitive_info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSensitive_info(@NotNull PoLParser.Sensitive_infoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#where_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere_clause(@NotNull PoLParser.Where_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#sensitive_fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSensitive_fields(@NotNull PoLParser.Sensitive_fieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(@NotNull PoLParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#constraint_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_declaration(@NotNull PoLParser.Constraint_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(@NotNull PoLParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(@NotNull PoLParser.FieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#clazz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClazz(@NotNull PoLParser.ClazzContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull PoLParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link PoLParser#program_parts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_parts(@NotNull PoLParser.Program_partsContext ctx);
}