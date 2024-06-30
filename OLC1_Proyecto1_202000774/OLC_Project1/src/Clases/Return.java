/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;

/**
 *
 * @author Gerson
 */
public class Return extends Instruccion{

    public Expresion value;
    public Types type = Types.NULL;
    public Return(int linea, int columna, Expresion value) {
        super(linea, columna, TypesIns.RETURN);
        this.value = value;
    }

    @Override
    public Object ejecutar(Entorno env) {
        if(this.value != null){
            ReturnTypes val = this.value.ejecutar(env);
            this.type = val.type;
            return new ReturnTypes(val.value, this.type);
        }
        
        return new ReturnTypes(this.typeInst.RETURN, this.type);
    }
    
}
