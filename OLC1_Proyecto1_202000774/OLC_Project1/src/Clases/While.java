/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Gerson
 */
public class While extends Instruccion{

    public Object condition;
    public Instruccion block;
    public While(int linea, int columna, Object condition, Instruccion block) {
        super(linea, columna, TypesIns.WHILE);
        this.condition = condition;
        this.block = block;
    }

        
    @Override
    public Object ejecutar(Entorno env) {
        //String entorno = String.format("s% while", env.nombre);
        //System.out.println(env.nombre);
        if(this.block==null){
            return new ReturnTypes("NULL", Types.NULL);
        }
        Entorno envWhile = new Entorno(env, "EntornoWhile");
        
        Class<?>[] tiposDeParametros = new Class<?>[] {Entorno.class}; // los tipos de los parámetros aquí
        Object[] valoresDeParametros = new Object[] {envWhile}; // los valores de los parámetros aquí

        try{
            Class<?> clase = this.condition.getClass();
            Method condicion1 = clase.getMethod("ejecutar", tiposDeParametros);
            ReturnTypes condicion = (ReturnTypes)condicion1.invoke(this.condition, valoresDeParametros);
            
            while((Boolean)condicion.value){
                ReturnTypes bloque = (ReturnTypes) this.block.ejecutar(envWhile);
                if(bloque!= null){
                    if(bloque.value == TypesIns.BREAK){
                        break;
                    }
                    else if(bloque.value == TypesIns.CONTINUE){
                        condicion = (ReturnTypes)condicion1.invoke(this.condition, valoresDeParametros);
                        continue;
                    }
                   
                    return bloque;
                }
                condicion = (ReturnTypes)condicion1.invoke(this.condition, valoresDeParametros);
            }
           
            
        }catch (NoSuchMethodException e) {
            System.out.println("El método 'ejecutar' no existe en el objeto.");
        } catch (IllegalAccessException e) {
            System.out.println("No se tiene acceso al método 'ejecutar'.");
        } catch (InvocationTargetException e) {
            System.out.println("Hubo un error al invocar el método 'ejecutar'.");
        }
        
        return null;
    }
    
}
