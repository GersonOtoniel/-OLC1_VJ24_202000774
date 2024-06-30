/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;

/**
 *
 * @author Gerson
 */
public class ValorStruct extends Instruccion {

    public String id;
    public Object value;
    public ValorStruct(int linea, int columna, String id, Object value) {
        super(linea, columna, TypesIns.INSTANCEVALUE);
        this.id = id;
        this.value = value;
    }

    @Override
    public Object ejecutar(Entorno env) {
        /*Aqui valida que sea una expresion, de lo contrario sera una instancia
        de struct*/
        if(this.value!=null){
            if(this.value instanceof Expresion){
                ReturnTypes val = ((Expresion) this.value).ejecutar(env);
                return new ReturnStructTypes(this.id, val);
            }
            else{
                //System.out.println("otra instancia");
                //System.out.println(this.value);
                return new ReturnStructTypes("STRUCT", this.value);
            }
            
        }
        return new ReturnStructTypes("NULL", Types.NULL);
    }
    
    
}
