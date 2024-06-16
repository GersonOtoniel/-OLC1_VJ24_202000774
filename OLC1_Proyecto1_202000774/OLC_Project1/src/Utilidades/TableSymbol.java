/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class TableSymbol {
    public static LinkedList<SimboloTab> symbolTable = new LinkedList<SimboloTab>();
   
    public static void push(int linea, int columna, String id, String typeId,String type, String env,String value, String mutabilidad ){
        var temp = new SimboloTab(linea, columna, id, typeId, type, env, value, mutabilidad);
        if(!validar(temp)){
            temp.n = symbolTable.size()+1;
            symbolTable.add(temp);
        }
    }
    
    public static Boolean validar(SimboloTab symbol){
        for(var simbolo: symbolTable){
            if(simbolo.type == symbol.type && simbolo.mutabilidad.equals(symbol.mutabilidad) && simbolo.id.equals(symbol.id) && simbolo.env == symbol.env && simbolo.typeId == symbol.typeId){
                return true;
            }
        }
        return false;
    }
    
    public static void crearTabla(){
        int contador = 0;
        String Tabla = "<!DOCTYPE html>\n<html>\n<head>\n<title>Tabla de Tokens</title>\n<style>table{}th,td{padding: 8px 130px;}</style></head>\n<body>\n<table border=\"1\" style =\"color: white;\" bgcolor = \"#34495E\">";
        Tabla+="<tr><td>" + "#" + "</td>"
                + "<td>" + "ID" + "</td>"
                + "<td>" + "Tipo" + "</td>"
                + "<td>" + "Tipo" + "</td>"
                + "<td>" + "Entorno" + "</td>"
                + "<td>" + "Valor" + "</td>"
                + "<td>" + "Linea" + "</td>"
                + "<td>" + "Columna" + "</td></tr>";
        
        for(var sim : symbolTable){
            
            Tabla+="<tr><td>" + contador + "</td>"
                + "<td>" + sim.id + "</td>"
                + "<td>" + sim.typeId + "</td>"
                + "<td>" + sim.type + "</td>"
                + "<td>" + sim.env + "</td>"
                + "<td>" + sim.value + "</td>"
                + "<td>" + sim.linea + "</td>"
                + "<td>" + sim.columna + "</td></tr>";
            contador++;
        }
        Tabla+= "</table>\n</body>\n</html>";
        
        
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("src/Utilidades/TablaSimbolo.html"), Tabla.getBytes());
            System.out.println("Archivo HTML creado exitosamente.");
        } catch (java.io.IOException e) {
            e.printStackTrace();}
        
        // Ruta al archivo HTML que creaste
        String rutaArchivoHTML = "src/Utilidades/TablaSimbolo.html";

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
