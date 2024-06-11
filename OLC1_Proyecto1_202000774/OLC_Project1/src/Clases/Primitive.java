/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesEx;

/**
 *
 * @author Gerson
 */
public class Primitive extends Expresion {
    public Object value;
    public Types type;
    public Primitive(int line, int column, Object value, Types type) {
        super(line, column, TypesEx.PRIMITIVE);
        this.value = value;
        this.type = type;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        switch(this.type){
            case Types.INT:
                return new ReturnTypes(Integer.parseInt((String) this.value),this.type);
            case Types.DECIMAL:
                return new ReturnTypes(Double.parseDouble((String) this.value), this.type);
                
            default:
                this.value = ((String) this.value).replace("\\n", "\n")
                        .replace("\\t", "\t")
                        .replace("\\r", "\r")
                        .replace("\\\"", "\"")
                        .replace("\\'", "'")
                        .replace("\\\\", "\\");
                        
                return new ReturnTypes(this.value,this.type);
                
        }
    }
    
}
