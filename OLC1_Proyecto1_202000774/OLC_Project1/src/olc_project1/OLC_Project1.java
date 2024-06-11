/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package olc_project1;

import Clases.Entorno;
import Clases.Instruccion;
import GUI.*;
import com.formdev.flatlaf.FlatDarkLaf;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import javacup.Lex;
import javacup.Simbol;
import java_cup.runtime.Symbol;
import javacup.Parser;
import Utilidades.Salidas;
import java.util.LinkedList;
import javax.swing.UIManager;

/**
 *
 * @author Gerson
 */
public class OLC_Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // Configura el tema oscuro
            Interfaz inter = new Interfaz();
        inter.setVisible(true);
        } catch (Exception ex) {
            System.err.println("Error al inicializar el Look and Feel");}
        
        /*try {

            String ruta1 = "D:/Desktop/SAN CARLOS/COMPILADORES1/LAB COMPI1/PROYECTO1/OLC1_Proyecto1_202000774/OLC_Project1/src/javacup/";
            String ruta2 = "src/javacup/";
            String[] archivo1 = {ruta2 + "Lexer.jflex", "-d", ruta2};
            jflex.Main.generate(archivo1);

            String[] archivo2 = {"-destdir", ruta2, "-parser", "Parser", ruta2 + "Sintax.cup"};
            java_cup.Main.main(archivo2);
        } catch (Exception e) {
        }

        
        try {
            
            String text = "var num:String = \"hola como estas\"; println(num);";
            Lex scanner = new Lex(new BufferedReader(new StringReader(text)));
            Parser parser = new Parser(scanner);
            var resultado = parser.parse();
            Entorno global = new Entorno(null, "Global");
          
            
            if(resultado.value instanceof LinkedList){
                LinkedList<?> lista = (LinkedList<?>) resultado.value;
                for(var elemento: lista){
                    if(elemento instanceof Instruccion){
                        ((Instruccion) elemento).ejecutar(global);
                    }
                }
            }
            System.out.println(Salidas.getConsola());
            //System.out.println(resultado.value);
            //System.out.println(Salidas.getConsola());
            System.out.println("Análisis terminado");
           
        } catch (Exception e) {
          System.out.println(e);
          System.out.println("Ocurrio un error");
          e.printStackTrace();
        }*/
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        String entrada = "PROGRAM\n	! Estadísticas de Ingeniería en Guatemala\nCONSOLE::PRINT = \"-----------------ESTADÍSTICAS DE INGENIERÍA EN GUATEMALA-----------------\" END;\n\n<! Datos estadísticos !>\n VAR::DOUBLE::ingenierosElectronicos <- 150.0 END;\nVAR::DOUBLE::ingenierosMecanicos <- 120.0 END;\nVAR::DOUBLE::ingenierosInformaticos <- 200.0 END;\n\nCONSOLE::PRINT = \"Ingenieros Electrónicos:\", ingenierosElectronicos END;\nCONSOLE::PRINT = \"Ingenieros Mecánicos:\", ingenierosMecanicos END;\nCONSOLE::PRINT = \"Ingenieros Informáticos:\", ingenierosInformaticos END;\n\nVAR::DOUBLE::totalIngenieros <- SUM(SUM(ingenierosElectronicos, ingenierosMecanicos), ingenierosInformaticos) END;\nCONSOLE::PRINT = \"Total de Ingenieros:\", totalIngenieros END;\n\nCONSOLE::COLUMN = \"Número de Ingenieros por Especialidad en Guatemala\" -> [ingenierosElectronicos, ingenierosMecanicos, ingenierosInformaticos] END;\n<!\n--------------------------------------------\nNúmero de Ingenieros por Especialidad en Guatemala\n--------------------------------------------\nIngenieros Electrónicos: 150.0\nIngenieros Mecánicos: 120.0\nIngenieros Informáticos: 200.0\nTotal de Ingenieros: 470.0\n!>\n\nGRAPH_BAR(\nlabels::STRING[] = [\"Electrónicos\", \"Mecánicos\", \"Informáticos\"] END;\nvalues::DOUBLE[] = [ingenierosElectronicos, ingenierosMecanicos, ingenierosInformaticos] END;\ntitle::STRING = \"Número de Ingenieros por Especialidad en Guatemala\" END;\nEXEC GRAPH_BAR\n) END;\n\nEND PROGRAM";
        Reader sr = new StringReader(entrada);
        Lexer lx = new Lexer(sr);
        
        Symbol tk = lx.next_token();
        while(tk.toString()!=null){
            System.out.println(tk.toString());
            tk = lx.next_token();
        }*/
 /*
        Token tok = new Token("var",TokenConstant.ID,1,4);
        Token tok1 = new Token("var1",TokenConstant.ID,7,6);
        Token tok2 = new Token("var2",TokenConstant.ID,2,2);
        Token tok3 = new Token("var3",TokenConstant.ID,0,5);
        Token tok4 = new Token("var4",TokenConstant.ID,78,21);
    
        ListaSimple list = new ListaSimple();
        list.add(tok);
        list.add(tok1);
        list.add(tok2);
        list.add(tok3);
        list.add(tok4);
        
        Nodo actual = list.cabeza;
        while(actual!=null){
            Token token = (Token) actual.getDato();
            System.out.println(token.getLexema() + ", "  + token.getType());
            actual = actual.siguiente;
        }*/
    }

    /*private static Reader StringReader(String entrada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
