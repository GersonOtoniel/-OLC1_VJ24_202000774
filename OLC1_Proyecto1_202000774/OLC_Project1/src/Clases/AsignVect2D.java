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
public class AsignVect2D extends Instruccion {
    
    public String id;
    public Expresion index1;
    public Expresion index2;
    public Expresion value;
    public AsignVect2D(int linea, int columna, String id, Expresion index1, Expresion index2, Expresion value) {
        super(linea, columna, TypesIns.ASIGNVECTOR2);
        this.id = id;
        this.index1 = index1;
        this.index2 = index2;
        this.value = value;
    }

    @Override
    public Object ejecutar(Entorno env) {
        ReturnTypes i = this.index1.ejecutar(env);
        ReturnTypes j = this.index2.ejecutar(env);
        ReturnTypes valor = this.value.ejecutar(env);
        Primitive primitive = new Primitive(this.linea, this.columna, valor, valor.type);
        
        Boolean respuesta = env.reasingValueMatrix(this.id, (int)i.value, (int)j.value, primitive);
        if(!respuesta){
            System.out.println("-->Error semantico: variable no encontrada");
        }
        return null;
    }
    
}
