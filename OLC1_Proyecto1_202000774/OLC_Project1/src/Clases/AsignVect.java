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
public class AsignVect extends Instruccion{

    public String id;
    public Expresion indice;
    public Expresion value;
    public AsignVect(int linea, int columna, String id, Expresion indice, Expresion value) {
        super(linea, columna, TypesIns.ASIGNVECTOR);
        this.id = id;
        this.indice = indice;
        this.value = value;
    }

    @Override
    public Object ejecutar(Entorno env) {
        ReturnTypes index = this.indice.ejecutar(env);
        ReturnTypes value = this.value.ejecutar(env);
        
        Primitive primitivo = new Primitive(this.linea, this.columna, value.value, value.type);
        env.reasignValueArray(this.id, (int)index.value, primitivo, value.type, null);
        return null;
    }
    
}
