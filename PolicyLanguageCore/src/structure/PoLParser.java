// Generated from PoL.g4 by ANTLR 4.4
// I made some changes on the source code :)

    package structure;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PoLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, ID=9, 
		PROG_PART=10, LETTER=11, DIGIT=12, WS=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'where'", "'noset'", "'noflow'", "';'", "'{'", "','", "'='", 
		"'}'", "ID", "PROG_PART", "LETTER", "DIGIT", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_module = 1, RULE_clazz = 2, RULE_fields = 3, RULE_program_parts = 4, 
		RULE_sensitive_fields = 5, RULE_sensitive_info = 6, RULE_where_clause = 7, 
		RULE_constraint = 8, RULE_constraint_declaration = 9;
	public static final String[] ruleNames = {
		"prog", "module", "clazz", "fields", "program_parts", "sensitive_fields", 
		"sensitive_info", "where_clause", "constraint", "constraint_declaration"
	};

	@Override
	public String getGrammarFileName() { return "PoL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PoLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public Constraint_declarationContext constraint_declaration() {
			return getRuleContext(Constraint_declarationContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); constraint_declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PoLParser.ID, 0); }
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_module);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClazzContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PoLParser.ID, 0); }
		public ClazzContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clazz; }
		
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitClazz(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClazzContext clazz() throws RecognitionException {
		ClazzContext _localctx = new ClazzContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_clazz);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PoLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PoLParser.ID, i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); match(ID);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(27); match(T__2);
				setState(28); match(ID);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Program_partsContext extends ParserRuleContext {
		public TerminalNode PROG_PART(int i) {
			return getToken(PoLParser.PROG_PART, i);
		}
		public List<TerminalNode> PROG_PART() { return getTokens(PoLParser.PROG_PART); }
		public Program_partsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_parts; }
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitProgram_parts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Program_partsContext program_parts() throws RecognitionException {
		Program_partsContext _localctx = new Program_partsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_program_parts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); match(PROG_PART);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(35); match(T__2);
				setState(36); match(PROG_PART);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sensitive_fieldsContext extends ParserRuleContext {
		public ClazzContext clazz() {
			return getRuleContext(ClazzContext.class,0);
		}
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public Sensitive_fieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensitive_fields; }
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitSensitive_fields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sensitive_fieldsContext sensitive_fields() throws RecognitionException {
		Sensitive_fieldsContext _localctx = new Sensitive_fieldsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sensitive_fields);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); clazz();
			setState(43); match(T__3);
			setState(44); fields();
			setState(45); match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sensitive_infoContext extends ParserRuleContext {
		public List<Sensitive_fieldsContext> sensitive_fields() {
			return getRuleContexts(Sensitive_fieldsContext.class);
		}
		public Sensitive_fieldsContext sensitive_fields(int i) {
			return getRuleContext(Sensitive_fieldsContext.class,i);
		}
		public Sensitive_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensitive_info; }
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitSensitive_info(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sensitive_infoContext sensitive_info() throws RecognitionException {
		Sensitive_infoContext _localctx = new Sensitive_infoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sensitive_info);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); sensitive_fields();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(48); match(T__2);
				setState(49); sensitive_fields();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public Program_partsContext program_parts() {
			return getRuleContext(Program_partsContext.class,0);
		}
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitWhere_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); match(T__7);
			setState(56); module();
			setState(57); match(T__1);
			setState(58); match(T__3);
			setState(59); program_parts();
			setState(60); match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public Sensitive_infoContext sensitive_info() {
			return getRuleContext(Sensitive_infoContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constraint);
		int _la;
		try {
			setState(74);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62); sensitive_info();
				setState(63); match(T__5);
				setState(64); module();
				setState(66);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(65); where_clause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); module();
				setState(69); match(T__6);
				setState(70); sensitive_info();
				setState(72);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(71); where_clause();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constraint_declarationContext extends ParserRuleContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public Constraint_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_declaration; }
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PoLVisitor ) return ((PoLVisitor<? extends T>)visitor).visitConstraint_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_declarationContext constraint_declaration() throws RecognitionException {
		Constraint_declarationContext _localctx = new Constraint_declarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constraint_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(76); constraint();
			setState(77); match(T__4);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17R\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\7\5 \n\5\f\5\16\5#\13\5\3\6\3\6\3\6"+
		"\7\6(\n\6\f\6\16\6+\13\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\b\65\n\b\f"+
		"\b\16\b8\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\nE\n\n\3\n"+
		"\3\n\3\n\3\n\5\nK\n\n\5\nM\n\n\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16"+
		"\20\22\24\2\2M\2\26\3\2\2\2\4\30\3\2\2\2\6\32\3\2\2\2\b\34\3\2\2\2\n$"+
		"\3\2\2\2\f,\3\2\2\2\16\61\3\2\2\2\209\3\2\2\2\22L\3\2\2\2\24N\3\2\2\2"+
		"\26\27\5\24\13\2\27\3\3\2\2\2\30\31\7\13\2\2\31\5\3\2\2\2\32\33\7\13\2"+
		"\2\33\7\3\2\2\2\34!\7\13\2\2\35\36\7\b\2\2\36 \7\13\2\2\37\35\3\2\2\2"+
		" #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\t\3\2\2\2#!\3\2\2\2$)\7\f\2\2%&\7"+
		"\b\2\2&(\7\f\2\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\13\3\2\2\2"+
		"+)\3\2\2\2,-\5\6\4\2-.\7\7\2\2./\5\b\5\2/\60\7\n\2\2\60\r\3\2\2\2\61\66"+
		"\5\f\7\2\62\63\7\b\2\2\63\65\5\f\7\2\64\62\3\2\2\2\658\3\2\2\2\66\64\3"+
		"\2\2\2\66\67\3\2\2\2\67\17\3\2\2\28\66\3\2\2\29:\7\3\2\2:;\5\4\3\2;<\7"+
		"\t\2\2<=\7\7\2\2=>\5\n\6\2>?\7\n\2\2?\21\3\2\2\2@A\5\16\b\2AB\7\5\2\2"+
		"BD\5\4\3\2CE\5\20\t\2DC\3\2\2\2DE\3\2\2\2EM\3\2\2\2FG\5\4\3\2GH\7\4\2"+
		"\2HJ\5\16\b\2IK\5\20\t\2JI\3\2\2\2JK\3\2\2\2KM\3\2\2\2L@\3\2\2\2LF\3\2"+
		"\2\2M\23\3\2\2\2NO\5\22\n\2OP\7\6\2\2P\25\3\2\2\2\b!)\66DJL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}