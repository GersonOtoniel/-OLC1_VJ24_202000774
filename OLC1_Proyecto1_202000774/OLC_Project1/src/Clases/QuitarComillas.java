/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Gerson
 */
public class QuitarComillas {
    public static String comillas(String cadena){
        if(cadena == null || cadena.length() <= 1){
            return "";
        }
        return cadena.substring(1, cadena.length()-1);
    }
    
    

}
