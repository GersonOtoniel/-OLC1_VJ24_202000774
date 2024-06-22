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
public class Vect2D extends Instruccion {

    public String id;
    public Types type;
    public LinkedList<Object> values;
    public String mutabilidad;
    public Vect2D(int linea, int columna, String id, String type, LinkedList<Object> values, String mutabilidad) {
        super(linea, columna, TypesIns.VECTOR2D);
        this.id = id;
        this.type = RetornarTipos.RetornarTipos(type);
        this.values = values;
        this.mutabilidad = mutabilidad;
    }

    @Override
    public Object ejecutar(Entorno env) {
        if(values!=null){
            ArrayList<ReturnTypes> valuestemp = new ArrayList<ReturnTypes>();
            for(var val: values){
                if(!val.getClass().isArray()){
                    //System.out.println(val);
                    //error
                    
                }
                ArrayList<ReturnTypes> valuestemp2 = new ArrayList<ReturnTypes>();
                for(var val2:(LinkedList<Object>)val){
                    ReturnTypes valor = ((Expresion)val2).ejecutar(env);
                    valuestemp2.add(valor);
                }
                valuestemp.add(new ReturnTypes(valuestemp2, Types.ARRAY));
            }
            //System.out.println(this.type);
            env.saveArray(this.linea, this.columna, this.id, this.type, valuestemp, this.mutabilidad);
        }
        return null;
    }
    
}
