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
public class For extends Instruccion{

    public Instruccion variable;
    public Expresion condition;
    public Instruccion inc_dec;
    public BloqueIns block;

    /**
     *
     * @param linea
     * @param columna
     * @param variable
     * @param condition
     * @param inc_dec
     * @param block
     */
    public For(int linea, int columna, Instruccion variable, Expresion condition, Instruccion inc_dec, BloqueIns block) {
        super(linea, columna, TypesIns.FOR);
        this.block = block;
        this.condition = condition;
        this.inc_dec = inc_dec;
        this.variable = variable;
    }

    /**
     *
     * @param env
     * @return
     */
    @Override
    public Object ejecutar(Entorno env) {
        String entorno = "EntornoFor";
        Entorno envFor = new Entorno(env, entorno);
        this.variable.ejecutar(envFor);
        ReturnTypes condicion = (ReturnTypes) this.condition.ejecutar(envFor);
        while((Boolean) condicion.value){
            ReturnTypes bloque = (ReturnTypes) this.block.ejecutar(envFor);
            if(bloque != null){
                if(bloque instanceof ReturnTypes){
                    if(bloque.value == TypesIns.BREAK){
                        break;
                    }
                    else if(bloque.value == TypesIns.CONTINUE){
                        this.inc_dec.ejecutar(envFor);
                        condicion = (ReturnTypes) this.condition.ejecutar(envFor);
                        continue;
                    }
                }
               
                return bloque;
                
            }
            this.inc_dec.ejecutar(envFor);
            condicion = (ReturnTypes) this.condition.ejecutar(envFor);
        }
        return null;
    }
    
}
