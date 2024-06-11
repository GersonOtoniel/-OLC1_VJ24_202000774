/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Clases.Types;

/**
 *
 * @author Gerson
 */
public class RetornarTipos {
    
    public static Types RetornarTipos(String type){
        type = type.toLowerCase();
        
        if(type.equals("int")){
            return Types.INT;
        }
        else if(type.equals("double")){
            return Types.DECIMAL;
        }
        else if(type.equals("bool")){
            return Types.BOOL;
        }
        else if(type.equals("char")){
            return Types.CHAR;
        }
        else if(type.equals("string")){
            return Types.STRING;
        }
        return Types.NULL;
    }
}
