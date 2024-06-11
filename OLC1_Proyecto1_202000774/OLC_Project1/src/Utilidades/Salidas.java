/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class Salidas {
    public static LinkedList<Object> printConsola = new LinkedList<Object>();
    public String Consola;
    
    public static String getConsola(){
        String result = "";
        for( var elemento : printConsola){
            result+= elemento;
        }
        result += "\n";
        return result;
    }
    
    public static void resetConsola(){
        printConsola.clear();
    }
}
