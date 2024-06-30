/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.RetornarTipos;
import Utilidades.TypesIns;

/**
 *
 * @author Gerson
 */
public class ValStruct extends Instruccion{

    public String id;
    public String type;
    public ValStruct(int linea, int columna, String id, String type) {
        super(linea, columna, TypesIns.VALUESTRUCT);
        this.id = id;
        this.type = type;
    }

    @Override
    public Object ejecutar(Entorno env) {
        if(this.id != null && this.type != null){
            Types validar = RetornarTipos.RetornarTipos(type);
            if(validar != Types.NULL){
        //En esta parte se valida si el tipo es NULL entonces es de tipo Struct, es decir nombre:(Struct->)persona
        //Entonces el value es el id del Struct y el tipo será NULL 
                return new ReturnTypes(this.id, validar);
            }
            //Si resulta que no retorna null entonces es de cierto tipo en este caso
            //puede ser int, double, char, String o bool, value = al tipo
            return new ReturnTypes(this.type, Types.STRUCT);
        }
        return new ReturnTypes("NULL", Types.NULL);
    }
    
}
