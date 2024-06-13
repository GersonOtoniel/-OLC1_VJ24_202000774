/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Simbolo;
import Utilidades.TypesEx;

/**
 *
 * @author Gerson
 */
public class IncDec extends Expresion{

    public String id;
    public String signo;
    public IncDec(int line, int column, String id, String signo) {
        super(line, column, TypesEx.INC_DEC);
        this.id = id;
        this.signo = signo;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        
        switch(this.signo){
            case "++":
                return this.Inc(env);
                
            case "--":
                return this.Dec(env);
                
            default:
                return null;
        }
    }
    
    
    public ReturnTypes Inc(Entorno env){
        Simbolo val = env.getValue(id);
        int inc1 = 0;
        double inc2 = 0.0;
        
        if(val.type == Types.INT){
            inc1 = (Integer)val.value;
            inc1++;
            val.value = inc1;
            
            Boolean respuesta1 = env.check(this.id, new ReturnTypes(val.value, val.type));
            if(!respuesta1){
                System.out.println("Errrorororororor");
            }
            return new ReturnTypes(val.value, val.type);
        }
        else if(val.type == Types.DECIMAL){
            inc2 = (double) val.value;
            inc2++;
            val.value = inc2;
            Boolean respuesta = env.check(this.id, new ReturnTypes(val.value, val.type));
            if(!respuesta){
                System.out.println("Errrorororororor");
            }
            return new ReturnTypes(val.value, val.type);
            
        }
        return null;
    }
    
    public ReturnTypes Dec(Entorno env){
        Simbolo val = env.getValue(id);
        int inc1 = 0;
        double inc2 = 0.0;
        
        if(val.type == Types.INT){
            inc1 = (Integer)val.value;
            inc1--;
            val.value = inc1;
            
            Boolean respuesta1 = env.check(this.id, new ReturnTypes(val.value, val.type));
            if(!respuesta1){
                System.out.println("Errrorororororor");
            }
            return new ReturnTypes(val.value, val.type);
        }
        else if(val.type == Types.DECIMAL){
            inc2 = (double) val.value;
            inc2--;
            val.value = inc2;
            Boolean respuesta = env.check(this.id, new ReturnTypes(val.value, val.type));
            if(!respuesta){
                System.out.println("Errrorororororor");
            }
            return new ReturnTypes(val.value, val.type);
            
        }
        return null;
    }
}
