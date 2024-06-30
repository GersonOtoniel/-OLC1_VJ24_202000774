/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class Struct extends Instruccion {

    public LinkedList<Object> values;
    public String id;
    public Struct(int linea, int columna, String id, LinkedList<Object> values) {
        super(linea, columna, TypesIns.STRUCT);
        this.values = values;
        this.id = id;
    }

    @Override
    public Object ejecutar(Entorno env) {
        env.saveStruct(this.id, this);
        return null;
    }
    
}
