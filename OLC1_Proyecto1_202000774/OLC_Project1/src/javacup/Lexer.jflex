package javacup;
import java.io.*;
import java_cup.runtime.*;


%%
%ignorecase
%line
%column
%class Lex
%cup
%public
%unicode
%function next_token
%state COMMENT
%init{
    yyline=1;
    yycolumn=1;
%init}
%{
	StringBuffer string = new StringBuffer();
	
	private Symbol Symbol(int type){
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol Symbol(int type, Object value){
		return new Symbol(type, yyline, yycolumn, value);
	}
%}
%eofval{
    return Symbol(sym.EOF);
%eofval}
digit = [0-9]+
double = {digit}\.{digit}
arroba = "@"
letter = [a-zA-Z]
whitespace = [ \t\n\r\f]+ | {LineTerminator}
multi =  ["/"]["*"][^"*"]*["*"]+([^/][^]*[*]+)*["/"]
LineTerminator = \r|\n|\r\n
%%

{multi} {/*Ignore*/}

{whitespace} {/*Ignore*/}
"//" .* {/*Ignore*/}

println {return new Symbol (sym.PRINTLN, yyline, yycolumn, yytext());}
console {return new Symbol (sym.CONSOLE, yyline, yycolumn, yytext());}

end {return new Symbol (sym.END,yyline, yycolumn, yytext());}
int {return new Symbol (sym.INT, yyline, yycolumn, yytext());}
double {return new Symbol (sym.DOUBLE,yyline, yycolumn,yytext());}
bool {return new Symbol (sym.BOOL, yyline, yycolumn, yytext());}
char {return new Symbol (sym.CHAR, yyline, yycolumn, yytext());}
String {return new Symbol (sym.TKSTRING, yyline, yycolumn, yytext());}

var {return new Symbol (sym.VAR, yyline, yycolumn,yytext());}
const {return new Symbol (sym.CONST, yyline, yycolumn, yytext());}
true {return new Symbol (sym.TRUE, yyline, yycolumn, yytext());}
false {return new Symbol (sym.FALSE, yyline, yycolumn, yytext());}




<YYINITIAL>{double}+ {return new Symbol (sym.DECIMAL, yyline, yycolumn,yytext());}
<YYINITIAL>{digit}+ {return new Symbol (sym.ENTERO, yyline, yycolumn, yytext());}
<YYINITIAL>"==" {return new Symbol (sym.IGUALACION, yyline, yycolumn, yytext());}
<YYINITIAL>"=" {return new Symbol (sym.IGUAL, yyline,yycolumn,yytext());}
<YYINITIAL>"!=" {return new Symbol (sym.DIFERENTE, yyline, yycolumn, yytext());}
<YYINITIAL>"<" {return new Symbol (sym.MENORQ, yyline, yycolumn, yytext());}
<YYINITIAL>"<=" {return new Symbol (sym.MENORIGUAL, yyline, yycolumn, yytext());}
<YYINITIAL>">" {return new Symbol (sym.MAYORQ, yyline, yycolumn, yytext());}
<YYINITIAL>">=" {return new Symbol (sym.MAYORIGUAL, yyline, yycolumn, yytext());}
<YYINITIAL>"/" {return new Symbol (sym.DIVISION, yyline, yycolumn, yytext());}
<YYINITIAL>"**" {return new Symbol (sym.POTENCIA, yyline, yycolumn, yytext());}
<YYINITIAL>"*" {return new Symbol (sym.MULTIPLICACION, yyline, yycolumn, yytext());}
<YYINITIAL>"%" {return new Symbol (sym.MODULO, yyline, yycolumn, yytext());}


<YYINITIAL>"++" {return new Symbol (sym.INC, yyline, yycolumn, yytext());}
<YYINITIAL>"--" {return new Symbol (sym.DEC, yyline, yycolumn, yytext());}
<YYINITIAL>"+" {return new Symbol (sym.SUMA, yyline,yycolumn,yytext());}
<YYINITIAL>"-" {return new Symbol (sym.MENOS, yyline,yycolumn,yytext());}


<YYINITIAL>";" {return new Symbol (sym.PYC, yyline, yycolumn,yytext());}
<YYINITIAL>":" {return new Symbol (sym.DP, yyline, yycolumn,yytext());}
<YYINITIAL>"||" {return new Symbol (sym.OR, yyline, yycolumn, yytext());}
<YYINITIAL>"&&" {return new Symbol (sym.AND, yyline, yycolumn, yytext());}
<YYINITIAL>"^" {return new Symbol (sym.XOR, yyline, yycolumn, yytext());}
<YYINITIAL>"!" {return new Symbol (sym.NOT, yyline, yycolumn, yytext());}

<YYINITIAL>"," {return new Symbol (sym.COMA, yyline, yycolumn,yytext());}
<YYINITIAL>"(" {return new Symbol (sym.PARENABRE, yyline, yycolumn,yytext());}
<YYINITIAL>")" {return new Symbol (sym.PARENCIERRA, yyline, yycolumn,yytext());}
<YYINITIAL>"[" {return new Symbol (sym.CORCHABRE, yyline, yycolumn,yytext());}
<YYINITIAL>"]" {return new Symbol (sym.CORCHCIERRA, yyline, yycolumn,yytext());}
<YYINITIAL> \"({letter})*\" {return new Symbol (sym.STRING, yyline, yycolumn,yytext());}
<YYINITIAL> \"([^\"\\\\]*(\\\\.[^\"\\\\]*)*)\" { return new Symbol (sym.STRING, yyline, yycolumn,yytext()); }
<YYINITIAL> \“([^\"\\\\]*(\\\\.[^\"\\\\]*)*)\”|“[^“”]*” { return new Symbol (sym.STRING, yyline, yycolumn,yytext()); }
<YYINITIAL> \'([^\'\\\\]*(\\\\.[^\'\\\\]*)*)\'|'[^'']*' {return new Symbol (sym.TKCHAR, yyline, yycolumn, yytext());}
<YYINITIAL> \'([^\'\\\\]*(\\\\.[^\'\\\\]*)*)\' { return new Symbol (sym.TKCHAR, yyline, yycolumn,yytext()); }
<YYINITIAL> "_" {return new Symbol (sym.UNDERSCORE, yyline, yycolumn,yytext());}
<YYINITIAL>({letter})+({letter}|{digit})* {return new Symbol (sym.ID, yyline,yycolumn,yytext());}

 . {System.err.println("Warning: unrecognized character " + yytext());}



