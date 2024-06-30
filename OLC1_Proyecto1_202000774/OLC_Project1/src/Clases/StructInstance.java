/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Simbolo;
import Utilidades.TypesIns;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class StructInstance extends Instruccion {
    
    public String id1;
    public String id2;
    public LinkedList<?> values;
    public String mutacion;
    public StructInstance(int linea, int columna, String id1, String id2, LinkedList<?> values, String mutacion) {
        super(linea, columna, TypesIns.INSTANCESTRUCT);
        this.id1 = id1;
        this.id2 = id2;
        this.values = values;
        this.mutacion = mutacion;
    }

    @Override
    public Object ejecutar(Entorno env) {
        Struct stc = env.getStruct(this.id2);
        //System.out.println(stc.values);
        LinkedList<Object> save_values = new LinkedList<Object>();
        if(this.values!=null){
            
            if(stc!=null){
                if(stc.values.size()!=this.values.size()){
                    System.out.println("-->Error: faltan atributos por declarar en la instancia");
                    //Error
                    return null;
                }
                
                for(var i = 0; i < this.values.size(); i++){
                    ReturnTypes atributoStruct = (ReturnTypes) ((ValStruct)stc.values.get(i)).ejecutar(env);
                    ReturnTypes atributoRecibido = (ReturnTypes)((ReturnStructTypes) ((ValorStruct)this.values.get(i)).ejecutar(env)).value;
                    //System.out.println(atributoRecibido.value);
                    if(atributoStruct.value instanceof String && atributoRecibido.value instanceof String){
                        //System.out.println("aca esta");
                        if(!atributoStruct.type.equals(atributoRecibido.type)){
                            System.out.println("-->Error: el atributo de esta instancia no corresponde con los atributos del struct");
                            return null;
                        }
                        //System.out.println("va de largo");
                    }
                    //----
                    save_values.add(((ReturnStructTypes) ((ValorStruct)this.values.get(i)).ejecutar(env)));
                }
            }
            //System.out.println("entra aca tambien");
            //env.saveID(this.linea, this.columna, this.id1, Types.STRUCT, this.values, this.mutacion);
            //System.out.println(save_values);
            env.saveID(this.linea, this.columna, this.id1, Types.STRUCT, save_values, this.mutacion);
            //aqui entro a uno de los valores de la instancia en este caso valor en la posicion 3 de la instancia
            /*Simbolo symb = env.getValue(id1);
            for(var i=0; i<((LinkedList<?>)symb.value).size();i++){
                //System.out.println(((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symb.value).get(i)).value).value);
                System.out.println(((ReturnStructTypes)((LinkedList<?>)symb.value).get(i)).id);//accedo al tipo de los atributos
            }*/
        }
        return null;
    }
    
}
