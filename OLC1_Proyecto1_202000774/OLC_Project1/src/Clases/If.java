/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gerson
 */
public class If extends Instruccion{
    
    public Object condition;
    public Instruccion instrucciones, elseins;
    public If(int linea, int columna, Object condition, Instruccion instrucciones, Instruccion elseins) {
        super(linea, columna, TypesIns.IF);
        this.condition = condition;
        this.instrucciones = instrucciones;
        this.elseins = elseins;
    }

    public If(int linea, int columna, Object condition, Instruccion instrucciones) {
        this(linea, columna, condition, instrucciones, null);
    }

    
    @Override
    public Object ejecutar(Entorno env) {
        
        Class<?>[] tiposDeParametros = new Class<?>[] {Entorno.class}; // los tipos de los parámetros aquí
        Object[] valoresDeParametros = new Object[] {env}; // los valores de los parámetros aquí

        try{
            Class<?> clase = this.condition.getClass();
            Method condicion1 = clase.getMethod("ejecutar", tiposDeParametros);
            ReturnTypes condicion = (ReturnTypes)condicion1.invoke(this.condition, valoresDeParametros);
            
            
            if((Boolean)condicion.value){
                ReturnTypes bloque = (ReturnTypes) this.instrucciones.ejecutar(env);
                if(bloque != null){
                    return bloque;
                }
                return null;
            }
            if(this.elseins != null){
                ReturnTypes bloqueElse = (ReturnTypes) this.elseins.ejecutar(env);
                if(bloqueElse != null){
                    return bloqueElse;
                }
            }
            
        }catch (NoSuchMethodException e) {
            System.out.println("El método 'ejecutar' no existe en el objeto.");
        } catch (IllegalAccessException e) {
            System.out.println("No se tiene acceso al método 'ejecutar'.");
        } catch (InvocationTargetException e) {
            System.out.println("Hubo un error al invocar el método 'ejecutar'.");
        }

        
        //ReturnTypes condicion = this.condition.ejecutar(env);
        
        return null;
        
    }
    
}
