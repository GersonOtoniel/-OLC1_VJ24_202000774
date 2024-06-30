/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class Print extends Instruccion {
    
    public Expresion toPrint;

    public Print(int linea, int columna, Expresion toPrint) {
        super(linea, columna, TypesIns.PRINTLN);
        this.toPrint = toPrint;
    }

    @Override
    public Object ejecutar(Entorno env) {
        ReturnTypes value = (this.toPrint != null) ? this.toPrint.ejecutar(env) : null;
        if(value.value instanceof LinkedList){
            String lista = env.imprimirArray((LinkedList<?>) value.value);
            env.setPrint((lista != null) ? lista + "\n": "");
        
            return null;
        }
        if(value.value instanceof ArrayList){
            String lista = env.imprimirArray2((ArrayList<?>) value.value);
            env.setPrint((lista != null) ? lista + "\n": "");
        
            return null;
        }
        env.setPrint((value != null) ? value.value + "\n": "");
        
        return null;
    }
    
}
