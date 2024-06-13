/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static Utilidades.MatrizOp.relation;
import Utilidades.TypesEx;

/**
 *
 * @author Gerson
 */
public class Relacional extends Expresion {
    
    public Expresion exp1;
    public Expresion exp2;
    public String signo;
    public Types type = Types.NULL;
    public Relacional(int line, int column, Expresion exp1, String signo, Expresion exp2) {
        super(line, column, TypesEx.RELATIONAL);
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.signo = signo;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        switch(this.signo){
            case "==":
                return this.Igualacion(env);
                
            case "!=":
                return this.Diferente(env);
             
            case ">":
                return this.greater(env);
               
            case "<":
                return this.less(env);
                
            case ">=":
                return this.greaterEqual(env);
                
            case "<=":
                return this.lessEqual(env);
                
            default:
                return null;
        }
    }
    
    
    public ReturnTypes Igualacion(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = relation[val1.type.ordinal()][val2.type.ordinal()];
        
        if(this.type == Types.NULL){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(this.type == Types.BOOL){
            if(val1.value instanceof Integer || val2.value instanceof Integer  || val1.value instanceof Double || val2.value instanceof Double ){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);
                
                boolean result;
                result = ((Number) val1.value).doubleValue() == ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if(val1.value instanceof String && val2.value instanceof String){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);
                boolean result;
                result = (val1.value.toString()).equals(val2.value.toString());
                return new ReturnTypes(result, this.type);
            }
            
        }
        
        return new ReturnTypes("NULL", Types.NULL); 
    }
    
    
    public ReturnTypes Diferente(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = relation[val1.type.ordinal()][val2.type.ordinal()];
        
        if(this.type == Types.NULL){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(this.type == Types.BOOL){
            if(val1.value instanceof Integer || val2.value instanceof Integer  || val1.value instanceof Double || val2.value instanceof Double ){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);
                //System.out.println(val1.value);
                //System.out.println(val2.value);
                boolean result;
                result = ((Number) val1.value).doubleValue() != ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if(val1.value instanceof String && val2.value instanceof String){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);
                boolean result;
                result = !(val1.value.toString()).equals(val2.value.toString());
                return new ReturnTypes(result, this.type);
            }
            
        }
        
        return new ReturnTypes("NULL", Types.NULL);    
    }
    
    
    public ReturnTypes greater(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = relation[val1.type.ordinal()][val2.type.ordinal()];
        
        if(this.type == Types.NULL){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(this.type == Types.BOOL){
            if(val1.value instanceof Integer || val2.value instanceof Integer  || val1.value instanceof Double || val2.value instanceof Double ){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);

                boolean result;
                result = ((Number) val1.value).doubleValue() > ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if(val1.value instanceof String && val2.value instanceof String){
                System.out.println("Error de comparacion: tipo string no puede utilizar esta operacion relacional");
                //aqui va error
            }
            
        }
        
        return new ReturnTypes("NULL", Types.NULL);         
    }
    
    
    
    public ReturnTypes less(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = relation[val1.type.ordinal()][val2.type.ordinal()];
      
        if(this.type == Types.NULL){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(this.type == Types.BOOL){
            if(val1.value instanceof Integer || val2.value instanceof Integer  || val1.value instanceof Double || val2.value instanceof Double || val1.type == Types.CHAR || val2.type == Types.CHAR){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);

                boolean result;
                result = ((Number) val1.value).doubleValue() < ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if("true".equals(val1.value.toString()) || "false".equals(val1.value.toString()) || "false".equals(val2.value.toString()) || "true".equals(val2.value.toString())){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);

                boolean result;
                result = ((Number) val1.value).doubleValue() < ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if(val1.value instanceof String && val2.value instanceof String){
                System.out.println("Error de comparacion: tipo string no puede utilizar esta operacion relacional");
                //aqui va error
            }
            
        }
        
        return new ReturnTypes("NULL", Types.NULL);    
    }
    
    
    public ReturnTypes greaterEqual(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = relation[val1.type.ordinal()][val2.type.ordinal()];
      
        if(this.type == Types.NULL){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(this.type == Types.BOOL){
            if(val1.value instanceof Integer || val2.value instanceof Integer  || val1.value instanceof Double || val2.value instanceof Double || val1.type == Types.CHAR || val2.type == Types.CHAR){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);

                boolean result;
                result = ((Number) val1.value).doubleValue() >= ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if("true".equals(val1.value.toString()) || "false".equals(val1.value.toString()) || "false".equals(val2.value.toString()) || "true".equals(val2.value.toString())){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);

                boolean result;
                result = ((Number) val1.value).doubleValue() >= ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if(val1.value instanceof String && val2.value instanceof String){
                System.out.println("Error de comparacion: tipo string no puede utilizar esta operacion relacional");
                //aqui va error
            }
            
        }
        
        return new ReturnTypes("NULL", Types.NULL);    
    }
    
    
    public ReturnTypes lessEqual(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = relation[val1.type.ordinal()][val2.type.ordinal()];
      
        if(this.type == Types.NULL){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(this.type == Types.BOOL){
            if(val1.value instanceof Integer || val2.value instanceof Integer  || val1.value instanceof Double || val2.value instanceof Double || val1.type == Types.CHAR || val2.type == Types.CHAR){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);

                boolean result;
                result = ((Number) val1.value).doubleValue() <= ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if("true".equals(val1.value.toString()) || "false".equals(val1.value.toString()) || "false".equals(val2.value.toString()) || "true".equals(val2.value.toString())){
                val1 = this.getValue(val1, env);
                val2 = this.getValue(val2, env);

                boolean result;
                result = ((Number) val1.value).doubleValue() <= ((Number) val2.value).doubleValue();
                return new ReturnTypes(result, this.type);
            }
            else if(val1.value instanceof String && val2.value instanceof String){
                System.out.println("Error de comparacion: tipo string no puede utilizar esta operacion relacional");
                //aqui va error
            }
            
        }
        
        return new ReturnTypes("NULL", Types.NULL);    
    }
    
    
    
    public ReturnTypes getValue(ReturnTypes value, Entorno env){
        int num=0;
        if(value.type == Types.BOOL){
            return new ReturnTypes( Boolean.valueOf((String) value.value) ? 1 : 0, Types.BOOL);
        }
        
        else if(value.type == Types.CHAR){
      
            if (value.value instanceof String ) {
                String ch = (String) value.value;
                num = (int) ch.replace("\'", "").charAt(0);
                
                
            }
            return new ReturnTypes(num, Types.CHAR);//aqui da error de char
        }
        
        else if(value.type == Types.INT){
            if((Integer) value.value < -2147483648 || (Integer) value.value > 2147483647){
                return null;//aqui creo un error
            }
        }
        
        return value;
    }
}
