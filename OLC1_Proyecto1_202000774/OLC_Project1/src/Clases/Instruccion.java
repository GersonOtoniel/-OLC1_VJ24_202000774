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
public abstract class Instruccion {
    public int linea;
    public int columna;
    public TypesIns typeInst;
    
    public Instruccion(int linea, int columna, TypesIns typeInst){
        this.linea = linea;
        this.columna = columna;
        this.typeInst = typeInst;
    }

    @Override
    public String toString() {
        return "Instruccion{" + "linea=" + linea + ", columna=" + columna + ", typeInst=" + typeInst + '}';
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public TypesIns getTypeInst() {
        return typeInst;
    }

    public void setTypeInst(TypesIns typeInst) {
        this.typeInst = typeInst;
    }
    
    public abstract Object ejecutar(Entorno env);
}
