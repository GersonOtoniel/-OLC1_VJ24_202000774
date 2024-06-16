/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Salidas;
import Utilidades.Simbolo;
import Utilidades.TypesEx;

/**
 *
 * @author Gerson
 */
public class Id_Acces extends Expresion {
    public String id;
    public Types type;
    public Id_Acces(int line, int column, String id) {
        super(line, column, TypesEx.ACCES_ID);
        this.id = id;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
       
        final Simbolo value = env.getValue(this.id);
        if(value.value.toString() == ""){
            this.type = value.type;
            return new ReturnTypes(value.value = "", this.type);
        }
        
        if(value == null){
            System.out.println("El id no existe, error semantico");
            String val = "null";
            String errorTipo = String.format("--> Error Semántico: el valor de esta variable es %s, puede deberse a que esta declarada en un entorno de bloque o que la variable no haya sido declarada\n", val );
            Salidas.printConsola.add(errorTipo);
            return new ReturnTypes("NULL", Types.NULL);
            //error semantico
        }
        
        this.type = value.type;
        return new ReturnTypes(value.value, this.type);
        
        //return new ReturnTypes("NULL", Types.NULL);
    }
    
}
