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
public class Append extends Instruccion{
    
    public String id;
    public Expresion value;
    public Append(int linea, int columna, String id, Expresion value) {
        super(linea, columna, TypesIns.APPEND);
        this.id = id;
        this.value = value;
    }

    @Override
    public Object ejecutar(Entorno env) {
        ReturnTypes val = this.value.ejecutar(env);
        //Primitive primitive = new Primitive(this.linea, this.columna, val.value, val.type);
        env.append(this.id, val);
        return null;
    }
    
}
