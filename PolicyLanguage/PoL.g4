grammar PoL;

@header {
    package structure;
}

prog : constraint_declaration*;

ID :    LETTER(LETTER|DIGIT)*;             // match lower-case identifiers
PROG_PART :  ID('.'ID)*;
LETTER: [a-zA-Z];
DIGIT:  [0-9];

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

module : ID;

clazz : ID;

fields  : ID(','ID)*;

program_parts: PROG_PART(','PROG_PART)*;

sensitive_fields : clazz '{' fields '}';

sensitive_info : sensitive_fields (',' sensitive_fields)*;

where_clause : 'where' module '=' '{' program_parts '}';

constraint : sensitive_info 'noflow' module where_clause?
                  | module 'noset' sensitive_info where_clause?;

constraint_declaration : (constraint ';');


