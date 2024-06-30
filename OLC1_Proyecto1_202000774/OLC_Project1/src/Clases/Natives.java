/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Salidas;
import Utilidades.Simbolo;
import Utilidades.TypesEx;
import Utilidades.TypesIns;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class Natives extends Expresion{

    public Expresion value;
    public String type;
    public String id;
    public Natives(int line, int column, Expresion value, String type) {
        super(line, column, TypesEx.NATIVE);
        this.value = value;
        this.type = type.toLowerCase();
    }
    
    public Natives(int line, int column, Expresion value, String type, String id){
        super(line, column, TypesEx.NATIVE);
        this.value = value;
        this.type = type.toLowerCase();
        this.id = id.toLowerCase();
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        ReturnTypes value = this.value.ejecutar(env);
        
        switch(this.type){
            case "round":
                return this.round(value);
             
            case "length":
                return this.lenght(value);
                
            case "tostring":
                return this.toString(value);
                
            case "find":
                Simbolo lista = env.ids.get(this.id.toLowerCase());
                return this.Find(value, lista);
                
            default:
                return new ReturnTypes("NULL", Types.NULL);
        }
    }
    
    public ReturnTypes round(ReturnTypes value){
        if(value.type == Types.INT || value.type == Types.DECIMAL){
            int result = (int) Math.round(((Number)value.value).doubleValue());
            return new ReturnTypes(result, Types.INT);
        }
        else{
            String errorVar = String.format("--> Error Semántico: El tipo %s no puede ser redondeado ya que no es de tipo entero o double.\n", value.type);
            Salidas.printConsola.add(errorVar);
            return new ReturnTypes("NULL", Types.NULL);
        }
    }
    
    public ReturnTypes lenght(ReturnTypes value){
        if(value.type == Types.STRING){
            if(value.value instanceof LinkedList){
                return new ReturnTypes(((LinkedList<?>)value.value).size(), Types.INT);
            }
            else if(value.value instanceof ArrayList){
                return new ReturnTypes(((ArrayList<?>)value.value).size(), Types.INT);
            }
            String result = (String) value.value.toString();
            int longitud = result.length();
            return new ReturnTypes(longitud, Types.INT);
        }
        return new ReturnTypes("NULL", Types.NULL);
    }
 
    public ReturnTypes toString(ReturnTypes value){
       
        if(value.type == Types.INT || value.type == Types.DECIMAL || value.type == Types.BOOL || value.type == Types.CHAR){
            return new ReturnTypes(value.value.toString(), Types.STRING);
        }
        else{
            String errorContante = String.format("-->Error Semántico: No se puede convertir a String el tipo de dato %s.\n", value.type);
            Salidas.printConsola.add(errorContante);
            return new ReturnTypes("NULL", Types.NULL);
        }
    }
    
    public ReturnTypes Find(ReturnTypes value, Simbolo lista){
        if(lista.typearray == TypesIns.VECTOR || lista.typearray == TypesIns.DINAMICLIST){
            
            if(lista.value instanceof LinkedList){
                
                for(var i = 0; i<((LinkedList<?>)lista.value).size(); i++){
                    var val1 = value.value;
                    var val2 = ((ReturnTypes)((LinkedList<?>)lista.value).get(i)).value;
                   
                    if(val1.equals(val2)){
                        //System.out.println("compara bien");
                        return new ReturnTypes(true, Types.BOOL);
                    }
                }
            }
            
        }
        else{
            return new ReturnTypes(false, Types.BOOL);
        }
        return new ReturnTypes(false, Types.BOOL);
    }
}
