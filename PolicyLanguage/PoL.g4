grammar PoL;

@header {
    package structure;
}

prog : constraint_declaration*;

constraint_declaration : (constraint ';');

constraint : sensitive_info 'noflow' module where_clause?
                  | module 'noset' sensitive_info where_clause?;

sensitive_info : sensitive_fields (',' sensitive_fields)*;

where_clause : 'where' module '=' '{' program_parts '}';

sensitive_fields : clazz '{' fields '}';

clazz : ID | PROG_PART;

module : ID;

fields  : ID(','ID)*;

program_parts: PROG_PART(','PROG_PART)*;

ID :    LETTER(LETTER|DIGIT)*;             // match lower-case identifiers
PROG_PART :  ID('.'ID)*('('')')?;
LETTER: [a-zA-Z];
DIGIT:  [0-9];

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
