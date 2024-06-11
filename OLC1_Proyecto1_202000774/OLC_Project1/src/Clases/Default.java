/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Gerson
 */
public class Default {
    public static Object getValueDefault(Types type){
        switch(type){
            case Types.INT:
                return 0;
            
            case Types.DECIMAL:
                return 0.0;
                
            case Types.BOOL:
                return true;
             
            case Types.STRING:
                return "";
                
            case Types.CHAR:
                return '0';
                
            default:
                return null;
        }
    }
}
