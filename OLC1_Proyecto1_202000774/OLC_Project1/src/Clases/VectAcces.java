/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Salidas;
import Utilidades.Simbolo;
import Utilidades.TypesEx;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

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
            return new ReturnTypes(((ReturnTypes)((LinkedList<?>)value.value).get((int)indice.value)).value, ((ReturnTypes)((LinkedList<?>)value.value).get((int)indice.value)).type);
        }
        
        if(value!=null){
            if(((int)indice.value) > ((LinkedList<?>)value.value).size()-1 || ((int) indice.value) < 0){
                //System.out.println("Error Semantico: indice fuera de rango");
                String errorVar = String.format("--> Error Semántico: El indice %s esta fuera de rango.\n", (int)indice.value);
                Salidas.printConsola.add(errorVar);
                return new ReturnTypes("NULL", Types.NULL);
            }
            return new ReturnTypes(((ReturnTypes)((LinkedList<?>)value.value).get((int)indice.value)).value, ((ReturnTypes)((LinkedList<?>)value.value).get((int)indice.value)).type);
        }
        return new ReturnTypes("NULL", Types.NULL);
    }
    
}
