/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Simbolo;
import Utilidades.TypesEx;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Gerson
 */
public class VectAcces extends Expresion{

    public String id;
    public Expresion index;
    public VectAcces(int line, int column, String id, Expresion index) {
        super(line, column, TypesEx.VECTORACCES);
        this.id = id;
        this.index =  index;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        ReturnTypes indice = this.index.ejecutar(env);
        Simbolo value = env.getValueArray(this.id);
        if(value==null){
            return new ReturnTypes("NULL", Types.NULL);
        }
        
        if(value.getClass().isArray()){
            return new ReturnTypes(((ReturnTypes)((ArrayList<?>)value.value).get((int)indice.value)).value, ((ReturnTypes)((ArrayList<?>)value.value).get((int)indice.value)).type);
        }
        
        if(value!=null){
            if(((int)indice.value) > ((ArrayList<?>)value.value).size() || ((int) indice.value) < 0){
                System.out.println("Error Semantico: indice fuera de rango");
                return new ReturnTypes("NULL", Types.NULL);
            }
            return new ReturnTypes(((ReturnTypes)((ArrayList<?>)value.value).get((int)indice.value)).value, ((ReturnTypes)((ArrayList<?>)value.value).get((int)indice.value)).type);
        }
        return new ReturnTypes("NULL", Types.NULL);
    }
    
}
