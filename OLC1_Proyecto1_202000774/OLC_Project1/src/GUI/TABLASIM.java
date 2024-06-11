/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static GUI.HTML.contenidoHTML;
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
public class TABLASIM {

    static String contenidoHTML = "<!DOCTYPE html>\n<html>\n<head>\n<title>Tabla de Simbolos HTML</title>\n<style>table{}th,td{padding: 8px 177px;}</style></head>\n<body>\n<table border=\"1\" style =\"color: white;\" bgcolor = \"#17202A\">";

    public static void tablaSimbolos() {
        int contador = 0;
        contenidoHTML += "<tr><th><h1>#</h1></th><th><h1>Nombre</h1></th><th><h1>Tipo</h1></th><th><h1>Valor</h1></th><th><h1>Linea</h1></th><th><h1>Columna</h1></th></tr>";

       
        for (int i = 0; i < javacup.Simbol.simbolos.size(); i++) {
            contenidoHTML += "<tr><td>" + contador + "</td>" + "<td>" + javacup.Simbol.simbolos.get(i).getNombre() + "</td>" + "<td>" + javacup.Simbol.simbolos.get(i).getTipo() + "</td>" + "<td>" + javacup.Simbol.simbolos.get(i).getValor() + "</td>" + "<td>" + javacup.Simbol.simbolos.get(i).getLinea() + "</td>" + "<td>" + javacup.Simbol.simbolos.get(i).getColumna() + "</td>";
            contador++;
        }

        String finalHtml = "</table>\n</body>\n</html>";
        contenidoHTML += finalHtml;

        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("src/GUI/TabladeSimbolos.html"), contenidoHTML.getBytes());
            System.out.println("Archivo HTML creado exitosamente.");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        
        // Ruta al archivo HTML que creaste
        String rutaArchivoHTML = "src/GUI/TabladeSimbolos.html";

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
