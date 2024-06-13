/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesEx;
import static Utilidades.MatrizOp.*;


/**
 *
 * @author Gerson
 */
public class Arithmetics extends Expresion {
    public Expresion exp1, exp2;
    public String signo;
    public Types type = Types.NULL;
    public Arithmetics(int line, int column, Expresion exp1, String signo, Expresion exp2){
        super(line, column, TypesEx.ARITHMETIC);
        this.exp1= exp1;
        this.exp2 = exp2;
        this.signo = signo;
    }
    
    public ReturnTypes ejecutar(Entorno env){
        switch(this.signo){
            case "+" :
                return this.plus(env);
            
            case "-":
                if(this.exp2 != null){
                    return this.minus(env);
                }
                return this.negative(env);
             
            case "*":
                return this.mult(env);
            
            case "/":
                return this.div(env);
                
            case "**":
                return this.pow(env);
                
            case "%":
                return this.mod(env);
                
            default:
                return null;
        }
    }
    
    public ReturnTypes plus(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        this.type = plus[val1.type.ordinal()][val2.type.ordinal()];
        
        Object result = "null";
        
        if(this.type == Types.NULL){
            return new ReturnTypes("null", Types.NULL);
        }
        else if(this.type == Types.INT){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            //result = Integer.parseInt((String) val1.value) + Integer.parseInt((String) val2.value);
            int resultINT = 0;
            resultINT = (Integer) val1.value + (Integer) val2.value;
            resultINT = (int) resultINT;
            return new ReturnTypes(resultINT, this.type);
        }
        else if(this.type == Types.DECIMAL){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            double resultDEC = 0.0;
            resultDEC = ((Number) val1.value).doubleValue() + ((Number) val2.value).doubleValue();
            //System.out.println(resultDEC);
            return new ReturnTypes(resultDEC, this.type);
        }
        else if(this.type == Types.STRING){
            
            if(val1.value instanceof Boolean){
                val1 = this.getBoleanString(val1, env);
                val2 = this.getValue(val2, env);
                String resultStr1 = "";
                resultStr1 = val1.value.toString() + val2.value.toString();
                return new ReturnTypes(resultStr1, this.type);
            }else if(val2.value instanceof Boolean){
                val1 = this.getValue(val1, env);
                val2 = this.getBoleanString(val2, env);
                String resultStr2 = "";
                resultStr2 = val1.value.toString() + val2.value.toString();
                return new ReturnTypes(resultStr2, this.type);
            }else if(val1.value instanceof Boolean && val2.value instanceof Boolean){
                val1 = this.getBoleanString(val1, env);
                val2 = this.getBoleanString(val2, env);
                String resultStr3 = "";
                resultStr3 = val1.value.toString() + val2.value.toString();
                return new ReturnTypes(resultStr3, this.type);
            }
            else if(val1.type == Types.CHAR){
                val1 = this.getCharacter(val1, env);
                val2 = this.getValue(val2, env);
                
                String resultStr3 = "";
                resultStr3 = val1.value.toString() + val2.value.toString();
                return new ReturnTypes(resultStr3, this.type);
                
            }
            else if(val2.type == Types.CHAR){
                val2 = this.getCharacter(val2, env);
                val1 = this.getValue(val1, env);
                
                String resultStr3 = "";
                resultStr3 = val1.value.toString() + val2.value.toString();
                return new ReturnTypes(resultStr3, this.type);
                
            }
            else if(val1.type == Types.CHAR){
                val1 = this.getCharacter(val1, env);
                val2 = this.getCharacter(val2, env);
                
                String resultStr3 = "";
                resultStr3 = val1.value.toString() + val2.value.toString();
                return new ReturnTypes(resultStr3, this.type);
                
            }
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            String resultStr = "";
            System.out.println(val1.value);
            System.out.println(val2.value);
            resultStr = val1.value.toString() + val2.value.toString();
            return new ReturnTypes(resultStr, this.type);
        }
        //result = val1.value + val2.value;
        return new ReturnTypes(result, this.type);
    }
    
    
    public ReturnTypes minus(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        if(val1.type==Types.CHAR){
            this.type = minus[val1.type.ordinal()-1][val2.type.ordinal()];
        }
        else if(val2.type==Types.CHAR){
            this.type = minus[val1.type.ordinal()][val2.type.ordinal()-1];
        }
        else if(val1.type == Types.BOOL || val1.type == Types.STRING || val1.type == Types.NULL ){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(val2.type == Types.BOOL || val2.type == Types.STRING || val2.type == Types.NULL ){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else{
        this.type = minus[val1.type.ordinal()][val2.type.ordinal()];
        }
        var resultado = "NULL";
        
        if(this.type == Types.NULL){
            return new ReturnTypes("null", Types.NULL);
        }        
        
        if(this.type == Types.INT){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            
            int resultInt = 0;
            resultInt = (Integer) val1.value - (Integer) val2.value;
            return new ReturnTypes(resultInt, this.type);
        }
        else if(this.type == Types.DECIMAL){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
           
            double resultDec = 0.0;
            resultDec = ((Number) val1.value).doubleValue() - ((Number) val2.value).doubleValue();
            return new ReturnTypes(resultDec, this.type);
        }        
        return new ReturnTypes(resultado, this.type);
    }
    
    
    public ReturnTypes mult(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        if(val1.type == Types.CHAR){
            this.type = mult[val1.type.ordinal()-1][val2.type.ordinal()];
        }
        else if(val2.type == Types.CHAR){
            this.type = mult[val1.type.ordinal()][val2.type.ordinal()-1];
        }
        else if(val1.type == Types.BOOL || val1.type == Types.STRING || val1.type == Types.NULL ){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(val2.type == Types.BOOL || val2.type == Types.STRING || val2.type == Types.NULL ){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else{
            this.type = mult[val1.type.ordinal()][val2.type.ordinal()];
        }
    
        
        if(this.type == Types.INT){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            int resultInt = 0;
            resultInt = (Integer) val1.value * (Integer) val2.value;
            
            return new ReturnTypes(resultInt, this.type);
        }
        else if(this.type == Types.DECIMAL){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            
            double resultDec = 0.0;
            resultDec = ((Number) val1.value).doubleValue() * ((Number) val2.value).doubleValue();
            return new ReturnTypes(resultDec, this.type);
        }
        
        return new ReturnTypes("NULL", Types.NULL);
    }
    
    
    public ReturnTypes div(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        
        if(val1.type == Types.CHAR){
            this.type = div[val1.type.ordinal()-1][val2.type.ordinal()];
        }
        else if(val2.type == Types.CHAR){
            this.type = div[val1.type.ordinal()][val2.type.ordinal()-1];
        }
        else if(val1.type == Types.BOOL || val1.type == Types.STRING || val1.type == Types.NULL ){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(val2.type == Types.BOOL || val2.type == Types.STRING || val2.type == Types.NULL ){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else{
            this.type = div[val1.type.ordinal()][val2.type.ordinal()];
        }
        
        if(this.type == Types.INT){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            
            if(((Number) val2.value).doubleValue()==0.0){
            System.out.println("Division por cero");//aqui va error
            }
            
            double resultInt = 0;
            resultInt = ((Number) val1.value).doubleValue() / ((Number) val2.value).doubleValue();
            return new ReturnTypes(resultInt, this.type);
        }
        else if(this.type == Types.DECIMAL){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            
            if(((Number) val2.value).doubleValue()==0.0){
            System.out.println("Division por cero");//aqui va error
            }
            
            double resultDec = 0.0;
            resultDec = ((Number) val1.value).doubleValue() / ((Number) val2.value).doubleValue();
            return new ReturnTypes(resultDec, this.type);
        }
        return new ReturnTypes("NULL", Types.NULL);
    }
    
    
    public ReturnTypes pow(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        if(val1.type == Types.BOOL || val1.type == Types.STRING || val1.type == Types.NULL || val1.type == Types.CHAR){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(val2.type == Types.BOOL || val2.type == Types.STRING || val2.type == Types.NULL || val2.type == Types.CHAR){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else{
            this.type = pow[val1.type.ordinal()][val2.type.ordinal()];
        }
        
        if(this.type == Types.INT){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            double resultInt = 0.0;
            resultInt = Math.pow((((Number) val1.value).doubleValue()),(((Number) val2.value).doubleValue()));
            
            return new ReturnTypes((int) Math.round(resultInt), this.type);
        }
        else if(this.type == Types.DECIMAL){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            double resultInt = 0.0;
            resultInt = Math.pow((((Number) val1.value).doubleValue()),(((Number) val2.value).doubleValue()));
            
            return new ReturnTypes(resultInt, this.type);
        }
        return new ReturnTypes("NULL", Types.NULL);
    }
    
    public ReturnTypes mod(Entorno env){
        ReturnTypes val1 = this.exp1.ejecutar(env);
        ReturnTypes val2 = this.exp2.ejecutar(env);
        
        if(val1.type == Types.BOOL || val1.type == Types.STRING || val1.type == Types.NULL || val1.type == Types.CHAR){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else if(val2.type == Types.BOOL || val2.type == Types.STRING || val2.type == Types.NULL || val2.type == Types.CHAR){
            return new ReturnTypes("NULL", Types.NULL);
        }
        else{
            this.type = pow[val1.type.ordinal()][val2.type.ordinal()];
        }
        
        if(this.type == Types.INT ||this.type == Types.DECIMAL){
            val1 = this.getValue(val1, env);
            val2 = this.getValue(val2, env);
            double result = 0.0;
            result = (((Number) val1.value).doubleValue()) % (((Number) val2.value).doubleValue());
            
            return new ReturnTypes(result, this.type);
        }
        
        
        return new ReturnTypes("NULL", Types.NULL);
    }
    
    
    public ReturnTypes negative(Entorno env){
        ReturnTypes val = this.exp1.ejecutar(env);
        this.type = val.type;
        
        if(this.type == Types.INT){
            return new ReturnTypes((Integer) val.value*-1,this.type);
        }
        else if(this.type==Types.DECIMAL){
            return new ReturnTypes((Double) val.value*-1, this.type);
        }
        
        return new ReturnTypes(null, Types.NULL);
    }
    
    

    public ReturnTypes getValue(ReturnTypes value, Entorno env){
        int num=0;
        if(value.type == Types.BOOL){
            System.out.println(value.value);
            return new ReturnTypes( Boolean.valueOf((String) value.value) ? 1 : 0, Types.BOOL);
        }
        
        else if(value.type == Types.CHAR){
            //System.out.println(value.value.getClass().getName());
            //System.out.println(value.value);
            if (value.value instanceof String ) {
                String ch = (String) value.value;
                num = (int) ch.replace("\'", "").charAt(0);
                //System.out.println("El valor numérico del carácter '" + ch + "' es: " + num);
                
            }
            return new ReturnTypes(num, Types.CHAR);
        }
        
        else if(value.type == Types.INT){
            if((Integer) value.value < -2147483648 || (Integer) value.value > 2147483647){
                return null;//aqui creo un error
            }
        }
        
        return value;
    }
    
    
    public ReturnTypes getBoleanString(ReturnTypes value, Entorno env){
        if(value.type == Types.BOOL){
            System.out.println(value.value);
            return new ReturnTypes( (Boolean) value.value ? "true" : "false", Types.STRING);
        }
        return null;
    }
    
    public ReturnTypes getCharacter(ReturnTypes value, Entorno env){
        if(value.type == Types.CHAR){
            return value;
        }
        return null;
    }
}
