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
public class Break extends Instruccion{

    public Break(int linea, int columna) {
        super(linea, columna, TypesIns.BREAK);
    }

    @Override
    public Object ejecutar(Entorno env) {
        return new ReturnTypes("NULL",Types.NULL);
    }
    
}
