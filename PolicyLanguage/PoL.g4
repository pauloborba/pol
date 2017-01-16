grammar PoL;

@header {
    package structure;
}

program : (constraint_declaration|constant_declaration)(';'program)* ;

constraint_declaration : sensitive_info 'noflow' module where_clause?
						| module 'noset' sensitive_info where_clause?; 

where_clause : 'where' constant_declaration (','constant_declaration)*;

constant_declaration : ID '=' (sensitive_info | module);

module :  '{' program_parts '}' | ID ;

sensitive_info : sensitive_fields(','sensitive_fields)* | ID ;

sensitive_fields : clazz '{' fields '}';

program_parts : single_method_call (',' single_method_call)*
			  | ID '|' contribution_expression
			  | commit_hash (',' commit_hash)*;

contribution_expression : contribution_spec
                        | contribution_expression '&&' contribution_expression
                        | contribution_expression '||' contribution_expression
                        | '!' contribution_expression;

contribution_spec : method_call;

method_call : single_method_call('.'method_call)*;

single_method_call : full_name'('argument_list?')';

argument_list : argument(','argument)*;

argument : author_id |contribution_id ;

author_id : STRING;

contribution_id : STRING;

commit_hash : STRING;

clazz : full_name;

full_name : ID('.'ID)*;

fields  : ID(','ID)*;

ID :    ('_'|'$'|LETTER)('_'|'$'|LETTER|DIGIT)*; 
LETTER: [a-zA-Z];
STRING : '"' ~('\r' | '\n' | '"')* '"';
DIGIT:  [0-9];
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
