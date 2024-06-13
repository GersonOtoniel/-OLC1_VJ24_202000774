/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Salidas;
import Utilidades.TypesEx;

/**
 *
 * @author Gerson
 */
public class Cast extends Expresion {
    
    public String tipo;
    public Expresion exp;
    public Entorno env;
    public Cast(int line, int column, String tipo, Expresion exp) {
        super(line, column, TypesEx.CAST);
        this.tipo = tipo.toLowerCase();
        this.exp = exp;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        this.env = env;
        switch(this.tipo){
            case "int":
                return this.toInt();
            
            case "double":
                return this.toDouble();
                
            case "char":
                return this.toChar();
                
            default:
                return null;
        }
    }
    
    public ReturnTypes toInt(){
        ReturnTypes val = this.exp.ejecutar(this.env);
    
        int num = 0;
        if(val.type == Types.DECIMAL || val.type == Types.CHAR){
            if(val.type == Types.CHAR){
                
                String ch = (String) val.value;
                num = (int) ch.replace("\'", "").charAt(0);
                return new ReturnTypes(num, Types.INT);
            }
            return new ReturnTypes(((Double) val.value).intValue() , Types.INT);
        }
        String castError = String.format("--> Error Semantico: No se puede castear a int el tipo %s \n", val.type);
        Salidas.printConsola.add(castError);
        return new ReturnTypes("NULL", Types.NULL);
    }
    
    public ReturnTypes toDouble(){
        ReturnTypes val = this.exp.ejecutar(this.env);
        double num = 0;
        if(val.type == Types.INT || val.type == Types.CHAR){
            if(val.type == Types.CHAR){
                String ch = (String) val.value;
                System.out.println("aqui si");
                num = (double) ch.replace("\'", "").charAt(0);
                System.out.println("aqui no");
                return new ReturnTypes(num, Types.INT);
            }
            return new ReturnTypes(((Integer) val.value).doubleValue(), Types.DECIMAL);
        }
        String castError = String.format("--> Error Semantico: No se puede castear a double el tipo %s \n", val.type);
        Salidas.printConsola.add(castError);
        return new ReturnTypes("NULL", Types.NULL);
    }
    
    public ReturnTypes toChar(){
        ReturnTypes val = this.exp.ejecutar(this.env);
        
        if(val.type == Types.INT){
            System.out.println((char)((int) val.value));
            return new ReturnTypes((char)((int) val.value), Types.CHAR);
        }
        String castError = String.format("--> Error Semantico: No se puede castear a char el tipo %s \n", val.type);
        Salidas.printConsola.add(castError);
        return new ReturnTypes("NULL", Types.NULL);
    }
    
}
