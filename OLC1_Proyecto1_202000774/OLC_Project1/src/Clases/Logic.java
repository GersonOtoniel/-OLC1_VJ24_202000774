/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesEx;

/**
 *
 * @author Gerson
 */
public class Logic extends Expresion {

    public Expresion exp1;
    public Expresion exp2;
    public String signo;
    public Types type = Types.NULL;
    public Logic(int line, int column, Expresion exp1, String signo, Expresion exp2) {
        super(line, column, TypesEx.LOGICAL);
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.signo = signo;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        switch(this.signo){
            case "||":
                return this.or(env);
                
            case "&&":
                return this.and(env);
                
            case "^":
                return this.xor(env);
                
            case "!":
                if(this.exp2 == null){
                    return this.not(env);
                }
            default:
                return null;
        }
    }
    
    public ReturnTypes or(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = Types.BOOL;
        
        if(val1.value instanceof String && !(val2.value instanceof String)){
            return new ReturnTypes(Boolean.valueOf((String) val1.value) || (Boolean) val2.value, this.type);
        }
        else if(val2.value instanceof String && !(val1.value instanceof String)){
            return new ReturnTypes((Boolean) val1.value || Boolean.valueOf((String) val2.value), this.type);
        }
        else if(val1.value instanceof String && val2.value instanceof String){
            return new ReturnTypes(Boolean.valueOf((String) val1.value) || Boolean.valueOf((String) val2.value), this.type);
        }
        
        return new ReturnTypes((Boolean) val1.value || (Boolean) val2.value, this.type);
    }
    
    public ReturnTypes and(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = Types.BOOL;
        
        if(val1.value instanceof String && !(val2.value instanceof String)){
            return new ReturnTypes(Boolean.valueOf((String) val1.value) && (Boolean) val2.value, this.type);
        }
        else if(val2.value instanceof String && !(val1.value instanceof String)){
            return new ReturnTypes((Boolean) val1.value && Boolean.valueOf((String) val2.value), this.type);
        }
        else if(val1.value instanceof String && val2.value instanceof String){
            return new ReturnTypes(Boolean.valueOf((String) val1.value) && Boolean.valueOf((String) val2.value), this.type);
        }
        
        return new ReturnTypes((Boolean) val1.value && (Boolean) val2.value, this.type);
    }
    
    public ReturnTypes xor(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = Types.BOOL;
        
        if(val1.value instanceof String && !(val2.value instanceof String)){
            return new ReturnTypes(Boolean.valueOf((String) val1.value) ^ (Boolean) val2.value, this.type);
        }
        else if(val2.value instanceof String && !(val1.value instanceof String)){
            return new ReturnTypes((Boolean) val1.value || Boolean.valueOf((String) val2.value), this.type);
        }
        else if(val1.value instanceof String && val2.value instanceof String){
            return new ReturnTypes(Boolean.valueOf((String) val1.value) ^ Boolean.valueOf((String) val2.value), this.type);
        }
        
        return new ReturnTypes((Boolean) val1.value ^ (Boolean) val2.value, this.type);
    }
    
    public ReturnTypes not(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        
        
        this.type = Types.BOOL;
        
        if(val1.value instanceof String){
            return new ReturnTypes(!(Boolean.valueOf((String) val1.value)), this.type);
        }
  
        
        return new ReturnTypes(!((Boolean) val1.value), this.type);
    }
}
