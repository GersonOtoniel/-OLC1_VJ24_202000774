/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java_cup.runtime.Symbol;
import javacup.Lex;

/**
 *
 * @author Gerson
 */
public class HTML {
        static String contenidoHTML = "<!DOCTYPE html>\n<html>\n<head>\n<title>Tabla de Tokens</title>\n<style>table{}th,td{padding: 8px 177px;}</style></head>\n<body>\n<table border=\"1\" style =\"color: white;\" bgcolor = \"#34495E\">";
    public static void archivoTokens(String texto) throws IOException{
        int contador = 0;
        contenidoHTML+="<tr><th><h1>#</h1></th><th><h1>Lexema</h1></th><th><h1>Tipo</h1></th><th><h1>linea</h1></th><th><h1>Columna</h1></th></tr>";
        Lex scanner = new Lex(new BufferedReader(new StringReader(texto)));
        Symbol token = null;
        do {
            token = scanner.next_token();
            //System.out.println("Valor: " + token.value + "Linea: " +token.left + "Columna: " + token.right);
            contenidoHTML+="<tr><td>" + contador + "</td>" + "<td>" + token.value + "</td>" + "<td>" + javacup.sym.terminalNames[token.sym] + "</td>" + "<td>" + token.left + "</td>" + "<td>" + token.right + "</td>";
            contador++;
        } while (token.value!=null);
        String finalHtml = "</table>\n</body>\n</html>";
        contenidoHTML+=finalHtml;
        
        
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("src/GUI/archivo_manual.html"), contenidoHTML.getBytes());
            System.out.println("Archivo HTML creado exitosamente.");
        } catch (java.io.IOException e) {
            e.printStackTrace();}
        
        // Ruta al archivo HTML que creaste
        String rutaArchivoHTML = "src/GUI/archivo_manual.html";

        // Intenta abrir el archivo con la aplicación predeterminada
        try {
            File archivoHTML = new File(rutaArchivoHTML);
            Desktop.getDesktop().open(archivoHTML);
            System.out.println("Archivo HTML abierto exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al abrir el archivo HTML.");
        }

        
    }

}
