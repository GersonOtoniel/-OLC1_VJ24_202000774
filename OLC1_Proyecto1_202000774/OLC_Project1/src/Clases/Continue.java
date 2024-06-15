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
public class Continue extends Instruccion{

    public Continue(int linea, int columna) {
        super(linea, columna, TypesIns.CONTINUE);
    }

    @Override
    public Object ejecutar(Entorno env) {
        return new ReturnTypes(this.typeInst, Types.NULL);
    }
    
}
