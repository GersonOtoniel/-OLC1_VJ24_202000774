/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesEx;
import Utilidades.TypesIns;
import java.util.ArrayList;

/**
 *
 * @author Gerson
 */
public class Match extends Instruccion{

    public Expresion exp;
    public ArrayList<Instruccion> cases;
    public Instruccion Default;
    public Match(int linea, int columna, Expresion exp, ArrayList<Instruccion> cases, Instruccion Default) {
        super(linea, columna, TypesIns.MATCH);
        this.exp = exp;
        this.cases = cases;
        this.Default = Default;
    }

    @Override
    public Object ejecutar(Entorno env) {
        
        Entorno envMatch = new Entorno(env, "EntornoMatch");
        if(this.cases!=null){
            Case case_;
            ReturnTypes exp1 = this.exp.ejecutar(env);
            //System.out.println(this.cases.size());
            for (int i = 0; i < this.cases.size(); i++) {
                case_ = (Case) this.cases.get(i);
                case_.setEvaluated(exp1);
                //System.out.println(exp1);
                ReturnTypes block = (ReturnTypes) case_.ejecutar(envMatch);
                //System.out.println(block);
                if (block != null){
                    
                    if (block.value == TypesEx.RETURN) {return null;}
                    else if (block.value == TypesIns.BREAK) {return null;}
                    return block;
                }
                else if(block == null){
                    continue;
                }
                
            }  
            
        }
        if(this.Default != null){
            ReturnTypes block = (ReturnTypes) this.Default.ejecutar(envMatch);
            if(block!=null){
                if(block.value == TypesEx.RETURN){return null;}
                else if(block.value==TypesIns.BREAK){return null;}
                return block;
            }
        }
        return null;
    }
    
}
