/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TableSymbol;
import Utilidades.TypeParameter;
import Utilidades.TypesEx;
import Utilidades.TypesIns;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class CallFuncEx extends Expresion {

    public String id;
    public LinkedList<Object> params;
    public CallFuncEx(int line, int column, String id, LinkedList<Object> params) {
        super(line, column, TypesEx.CALL);
        this.id = id;
        this.params = params;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        Function func = env.getFunction(this.id.toLowerCase());
        
        if(func==null){
            System.out.println("Error la funcion no existe en este entorno o contexto");//ERROR
            return null;
        }
        
        String typefunc = this.getTypeFunc(func.type);
        
        if(typefunc.equals("void")){
            System.out.println("-->Error: esta funcion es de tipo void, returna null");//ERROR
            return null;
        }
       
        
        Entorno envFunc = new Entorno(env, String.format("Funcion %s", this.id.toLowerCase()));
        
        if(func.parametros.size() != this.params.size()){
            System.out.println("Error: la funcion (Nombre) necesita (aqui va la canditad de params), (cantidad encontrada) parametros encontrados ");
            return null;
        }
        
        Parameter validacionArrays;
        for(var i = 0; i<func.parametros.size(); i++){
            ReturnTypes paramActual = (ReturnTypes) ((Expresion)this.params.get(i)).ejecutar(env);
            ReturnTypes paramFunc = (ReturnTypes) ((Expresion)func.parametros.get(i)).ejecutar(env);
            
            validacionArrays = (Parameter) func.parametros.get(i);
            
            if(paramActual.type == paramFunc.type || (validacionArrays.typeparam == TypeParameter.LIST || validacionArrays.typeparam == TypeParameter.VECTOR || validacionArrays.typeparam == TypeParameter.VECTOR2) && paramActual.type == Types.STRING){
                if(envFunc.ids.containsKey(((Parameter)func.parametros.get(i)).id.toLowerCase())){
                    System.out.println("-->Error Semántico: Este parámetro ya existe en este entorno");
                    return null;
                }
                
                if(validacionArrays.typeparam == TypeParameter.LIST || validacionArrays.typeparam == TypeParameter.VECTOR || validacionArrays.typeparam == TypeParameter.VECTOR2){
                    if(paramActual.type != Types.STRING){
                        System.out.println("-->Error semántico: el parametro validacionArrays.id no es del tipo Vector o Lista");
                        return null;
                    }
                    
                    if(validacionArrays.typeparam == TypeParameter.VECTOR2 || validacionArrays.typeparam == TypeParameter.VECTOR ){
                        envFunc.saveArray(validacionArrays.line, validacionArrays.column, validacionArrays.id, validacionArrays.type, paramActual.value, "var");
                        if(paramActual.value instanceof LinkedList){
                            TableSymbol.push(validacionArrays.line, validacionArrays.column, validacionArrays.id, "Variable", env.getType(paramActual.type), env.nombre.toString(), envFunc.imprimirArray((LinkedList<?>)paramActual.value), "var");
                        }
                        else if(paramActual.value instanceof ArrayList){
                            TableSymbol.push(validacionArrays.line, validacionArrays.column, validacionArrays.id, "Variable", env.getType(paramActual.type), env.nombre.toString(), envFunc.imprimirArray2((ArrayList<?>)paramActual.value), "var");
                        }
                        //para la tabla de simbolos
                        continue;
                    }
                    else if(validacionArrays.typeparam == TypeParameter.LIST){
                        envFunc.saveDinamicList(validacionArrays.line, validacionArrays.column,validacionArrays.id, (LinkedList<?>) paramActual.value, validacionArrays.type, "vars");
                        //agragar a la tabla de simbolos
                        TableSymbol.push(validacionArrays.line, validacionArrays.column, validacionArrays.id, "Variable", env.getType(paramActual.type), env.nombre.toString(), envFunc.imprimirArray((LinkedList<?>)paramActual.value), "var");
                        continue;
                    }
                }
                else{
                    envFunc.saveID(((Expresion)func.parametros.get(i)).line, ((Expresion)func.parametros.get(i)).column, ((Parameter)func.parametros.get(i)).id, paramActual.type, paramActual.value, "var");
                    TableSymbol.push(((Expresion)func.parametros.get(i)).line, ((Expresion)func.parametros.get(i)).column, ((Parameter)func.parametros.get(i)).id, "Variable", env.getType(paramActual.type), envFunc.nombre.toString(), paramActual.value.toString(), "var");
                    //agregar a la tabla de simbolos
                    continue;
                }
            }
            else{
                System.out.println("-->Error semantico: El parametro no es del mismo tipo requerido");
                //tabla de errores
            }
        }
        ReturnTypes ejecut = (ReturnTypes) func.block.ejecutar(envFunc);
        
        if(typefunc.equals("void") && ejecut!=null){
            if(ejecut.value == TypesIns.RETURN){
               System.out.println("-->Error semántico: funcion de tipo void no puede usar la instruccion return");//ERROR
            }
            //return null;
        }
        
            if(ejecut!=null){
                if(ejecut.value == TypesIns.RETURN){
                    return null;
                }

                return ejecut;
             }
        
        return null;
    }
    
    
    public String getTypeFunc(Types type){
        if(type == Types.BOOL){
            return "bool";
        }
        else if(type == Types.CHAR){
            return "char";
        }
        else if(type == Types.DECIMAL){
            return "double";
        }
        else if(type == Types.INT){
            return "int";
        }
        else if(type == Types.STRING){
            return "String";
        }
        return "void";
    }
}
