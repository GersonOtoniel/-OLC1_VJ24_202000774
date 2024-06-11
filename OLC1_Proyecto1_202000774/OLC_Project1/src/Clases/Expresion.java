/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesEx;

/**
 *
 * @author Gerson
 */
public abstract class Expresion {
    public int line;
    public int column;
    public TypesEx typeExp;
    
    public Expresion(int line, int column, TypesEx typeExp){
        this.line = line;
        this.column = column;
        this.typeExp = typeExp;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public TypesEx getTypeExp() {
        return typeExp;
    }

    public void setTypeExp(TypesEx typeExp) {
        this.typeExp = typeExp;
    }
    
    public abstract ReturnTypes ejecutar(Entorno env);
    
}
