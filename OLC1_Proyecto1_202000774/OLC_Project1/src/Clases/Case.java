/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;
import java.util.Arrays;

/**
 *
 * @author Gerson
 */
public class Case extends Instruccion{

    public Expresion exp;
    public Instruccion block;
    public ReturnTypes evaluated = null;
    public Case(int linea, int columna, Expresion exp, Instruccion block) {
        super(linea, columna, TypesIns.CASE);
        this.exp = exp;
        this.block = block;
    }
    

    @Override
    public Object ejecutar(Entorno env) {
        //System.out.println(this.exp.ejecutar(env).value);
        Entorno envCase = new Entorno(env, "EntornoCase");
        ReturnTypes caso1 = this.evaluated;
        ReturnTypes caso2 = this.exp.ejecutar(envCase);
        //env.nombre = String.format("s% case s%", env.nombre, caso2.value);
        //System.out.println(caso1.value +"--" + caso2.value);
        //System.out.println(caso1.value);
        if(caso2.value == caso1.value){
            var block1 = (ReturnTypes) this.block.ejecutar(envCase);
            //return block;
            
            if(block1.value!=null){
                System.out.println("no es null");
                return block1;
            }
            return null;
           
        }
        
        return null;
    }

    public void setEvaluated(ReturnTypes evaluated) {
        this.evaluated = evaluated;
    }
    
}
