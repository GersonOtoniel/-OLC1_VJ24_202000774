/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

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
        
        if(value == null){
            System.out.println("El id no existe, error semantico");
            //error semantico
        }
        
        this.type = value.type;
        return new ReturnTypes(value.value, this.type);
        
        //return new ReturnTypes("NULL", Types.NULL);
    }
    
}
