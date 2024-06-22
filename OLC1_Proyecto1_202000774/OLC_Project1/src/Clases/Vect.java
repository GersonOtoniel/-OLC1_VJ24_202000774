/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.RetornarTipos;
import Utilidades.TypesIns;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class Vect extends Instruccion{
    
    public String id;
    public Types type;
    public LinkedList<Object> values;
    public String mutabilidad;
    public Vect(int linea, int columna, String id, String type, LinkedList<Object> values, String mutabilidad) {
        super(linea, columna, TypesIns.VECTOR);
        this.id = id;
        this.type = RetornarTipos.RetornarTipos(type);
        this.values = values;
        this.mutabilidad = mutabilidad;
    }

    @Override
    public Object ejecutar(Entorno env) {
        //System.out.println(((Expresion)this.values.get(2)).ejecutar(env).value);
        if(values!=null){
            ArrayList<ReturnTypes> save_values = new ArrayList<ReturnTypes>();
            int cont = 0;
            for(var val: values){
                
                //AQUI DEBO DE AGREGAR OTROS IF'S PARA VALIDAR NATIVAS
                if(val instanceof Expresion){
                    ReturnTypes temp1 = ((Expresion) val).ejecutar(env);
                    if(temp1.type != this.type){
                        System.out.println("Error no son del mismo tipo " + "linea: " + ((Expresion) val).line + " columna: " + ((Expresion) val).column);
                        return null;
                    }
                    save_values.add(temp1); 
                }
                if(val instanceof Instruccion){
                    ReturnTypes temp2 = (ReturnTypes) ((Instruccion) val).ejecutar(env);
                    if(temp2.type != this.type){
                        System.out.println("Error no son del mismo tipo instruccion");
                        return null;
                    }
                    save_values.add(temp2);
                    
                }
            }
            env.saveArray(this.linea, this.columna, this.id, this.type, save_values, this.mutabilidad);
        }
        return null;
    }
    
}
