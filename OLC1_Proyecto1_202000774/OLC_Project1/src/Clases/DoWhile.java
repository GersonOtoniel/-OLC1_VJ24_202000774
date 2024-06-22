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
public class DoWhile extends Instruccion{

    public Expresion condition; 
    public Instruccion block;
    public DoWhile(int linea, int columna, Expresion condition, Instruccion block) {
        super(linea, columna, TypesIns.DOWHILE);
        this.condition = condition;
        this.block = block;
    }

    @Override
    public Object ejecutar(Entorno env) {
        ReturnTypes condicion = null;
       
        Entorno envDoWhile = new Entorno(env, "Entorno DoWhile");
        do{
            ReturnTypes bloque = (ReturnTypes) this.block.ejecutar(envDoWhile);
            if(bloque != null){
                if(bloque.value == TypesIns.CONTINUE){
                    condicion = (ReturnTypes) this.condition.ejecutar(envDoWhile);
                    continue;
                }
                else if(bloque.value == TypesIns.BREAK){
                    break;
                }
                return bloque;
            }
            condicion = (ReturnTypes) this.condition.ejecutar(envDoWhile);
            if(condicion.value instanceof String){
            condicion.value = Boolean.parseBoolean((String) condicion.value);
        }
        }
        while((Boolean) condicion.value);
        return null;
    }
    
}
