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
        Boolean defaultcase = false;
        Entorno envMatch = new Entorno(env, "EntornoMatch");
        if(this.cases!=null){
            Case case_;
            
            ReturnTypes exp1 = this.exp.ejecutar(env);
            for (int i = 0; i < this.cases.size(); i++) {
                case_ = (Case) this.cases.get(i);
                case_.setEvaluated(exp1);
                Object block = (Object) case_.ejecutar(envMatch);
                if (block instanceof ReturnTypes){
                    if (((ReturnTypes)block).value == TypesEx.RETURN) {return null;}
                    else if (((ReturnTypes)block).value == TypesIns.BREAK) {return null;}
                    return block;
                }
                else if((Boolean)block == true){
                    defaultcase=false;
                    break;
                }
                else if((Boolean)block == false){
                    defaultcase=true;
                    continue;
                }
                
            }  
            
        }
        if(defaultcase!=false){
            if(this.Default != null){
                ReturnTypes block = (ReturnTypes) this.Default.ejecutar(envMatch);
                if(block!=null){
                    if(block.value == TypesEx.RETURN){return null;}
                    else if(block.value==TypesIns.BREAK){return null;}
                    return block;
                }
            }
        }
        return null;
    }
    
}
