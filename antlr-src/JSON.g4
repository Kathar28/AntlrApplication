// define a grammar called Hello
grammar JSON;
@header {package com.antlr;}

json : value EOF;

value : (STRING|NUMBER|object|array|'true'|'false'|'null');

STRING: '"' (SCHAR|TEXT)* '"';

NUMBER: '0' | DIGIT;

object : '{' pair (',' pair)* '}'
       |'{' '}';

array: '[' value ( ',' value)* ']'
     | '[' ']';

pair: STRING ':' value;

DIGIT : '-'? (INTEGER | FRACTION | EXPONENT);

INTEGER: [0-9]+;

FRACTION: INTEGER '.' INTEGER;

EXPONENT: INTEGER ('.' INTEGER )? [eE] [+-]? INTEGER;

fragment SCHAR : '\\' (["\\bfnrt] | UNICODE);

fragment TEXT : ~[\\"]+ ;

fragment UNICODE : 'u' HEX HEX HEX HEX;

fragment HEX: [a-fA-F0-9];

WS : [ \n\r\t] -> skip;

