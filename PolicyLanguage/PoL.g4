grammar PoL;

@header {
    package structure;
}

program : (constraint_declaration(';'program)*) | (constant_declaration(';'program)*) ;

constraint_declaration : sensitive_info 'noflow' module where_clause?
						| module 'noset' sensitive_info where_clause?; 

where_clause : 'where' constant_declaration;

constant_declaration : ID '=' sensitive_info | ID '=' module;

module : ID | '{' program_parts '}';

sensitive_info : ID | sensitive_fields(','sensitive_fields)*;

sensitive_fields : clazz '{' fields '}';

program_parts : method_set
			  | ID '|' contribution_expression
			  | commit_hash (',' commit_hash)*;

method_set : method_name (',' method_name)*;

contribution_expression : contribution_spec
                        | contribution_expression '&&' contribution_expression
                        | contribution_expression '||' contribution_expression;

contribution_spec : method_invocation;

method_invocation : method_name'('argument_list')'('.'method_invocation)*;

method_name : ambiguous_name;

ambiguous_name : TYPE_NAME | METHOD_NAME;

argument_list : argument(','argument)*;

argument : author_id |contribution_id ;

author_id : string_literal;

contribution_id : string_literal;

commit_hash : string_literal;

string_literal : STRING;

clazz : ID | TYPE_NAME;

fields  : ID(','ID)*;

ID :    LETTER(LETTER|DIGIT)*; 
METHOD_NAME :  ID('.'ID)*('('')');
TYPE_NAME :  ID('.'ID)*;
LETTER: [a-zA-Z];
STRING : '"' ~('\r' | '\n' | '"')* '"';
DIGIT:  [0-9];
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
