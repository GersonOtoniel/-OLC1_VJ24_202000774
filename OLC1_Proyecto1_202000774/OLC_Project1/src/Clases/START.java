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
public class START extends Instruccion {

    public Instruccion call;
    public START(int linea, int columna, Instruccion call) {
        super(linea, columna, TypesIns.START);
        this.call = call;
    }

    @Override
    public Object ejecutar(Entorno env) {
        this.call.ejecutar(env);
        return null;
    }
    
}
