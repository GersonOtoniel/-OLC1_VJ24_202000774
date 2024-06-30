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
public class RemoveIns extends Instruccion {

    public String id;
    public Expresion index;
    public RemoveIns(int linea, int columna, String id, Expresion index) {
        super(linea, columna, TypesIns.REMOVEINS);
        this.id = id;
        this.index = index;
    }

    @Override
    public Object ejecutar(Entorno env) {
        
        ReturnTypes indice = this.index.ejecutar(env);
        ReturnTypes value = env.remove(this.id, (int)indice.value);
        
        //return new ReturnTypes(value.value, value.type);
        return null;
    }
    
}
