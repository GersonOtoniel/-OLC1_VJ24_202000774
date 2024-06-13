/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;

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
        env.setPrint((value != null) ? value.value + "\n": "");
        
        return null;
    }
    
}
