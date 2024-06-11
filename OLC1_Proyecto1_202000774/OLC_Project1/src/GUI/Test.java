/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.BufferedReader;
import java.io.StringReader;
import java_cup.runtime.Symbol;
import javacup.Lex;
import javacup.Parser;
import javacup.sym;

/**
 *
 * @author Gerson
 */
public class Test {

    public static void main(String[] args) {

        try {

            String text = "PROGRAM var:double:: cosa <-5 end ; \narr:char[]::@darray <- [1,\"xy\",cosa] end ;\nvar:double:: suma <- MUL(SUM(2,3), cosa) end;\nconsole::print=\"hola1\",\"hola\", cosa,34, SUM(MUL(4,2), SUM(1,1)) end;\n END PROGRAM";
            String text2 = "PROGRAM\narr:double::@lista<-[1,2,3,4,5] end ;\narr:double::@lista2<-[78,45,12] end ;\narr:double::@cualquiercosa<-[88,5,4,3,9,7] end ;\nvar:char[]:: titul <- \"Enteros\" end;\n console::column = \"Enteros\"->@lista end; END PROGRAM";
            String text3 = "PROGRAM\ngraphPie(label::char[] = [“Uno”,\"Dos\",\"Tres\"] end;\nvalues::double = [50,30,20] end;\ntitulo::char[] = \"Ejemplo Grafica de Pie\" end; EXEC graphPie end;)end; END PROGRAM";
            String text4 = """
                           PROGRAM\n
                           var:double::cosa <- 6 end;
                           <!
                           \t\tMuestra una grafica de Pie
                           \t\tTitulo "Titulo que se debe mostrar" 
                           \t\tLabels 
                           \t\tDato correcto es el 20
                           \t\tDato 2 es el 70
                           \t!> 
                           
                           END PROGRAM """;
            
            
            
            String text5 = "var num: int;\n const ad:double = 4.5;\n var palabra:String = \"hola como estas\";\nprintln(0 - 'a');";
            Lex scanner = new Lex(new BufferedReader(new StringReader(text5)));

            Symbol token = null;
            do{
                token = scanner.next_token();
                //if(token.value!=null){
                if(sym.terminalNames[token.sym]=="STRING"){
                    System.out.println("token: " + token.value.toString().replace("\"", "") + "---" + sym.terminalNames[token.sym]);
                    continue;
                }
                
                    System.out.println("token: " + token.value + "---" + sym.terminalNames[token.sym]);    
                //}
            }while(token.value!=null);              
            Parser parser = new Parser(scanner);
            parser.parse();
            System.out.println("Análisis terminado");

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static String Parseo(String texto) {
        String r = "";
        String resultado="";
        try {
            Lex scanner = new Lex(new BufferedReader(new StringReader(texto)));
            Parser parser = new Parser(scanner);
            resultado = parser.parse().toString();
            
            r = parser.resultado;
            System.out.println("\n\n");
            System.out.println("terminado");

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return r;
    }
}
