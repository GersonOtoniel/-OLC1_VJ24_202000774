/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.RetornarTipos;
import Utilidades.TypeParameter;
import Utilidades.TypesEx;

/**
 *
 * @author Gerson
 */
public class Parameter extends Expresion {

    public String id;
    public Types type;
    public TypeParameter typeparam;
    public Parameter(int line, int column, String id, String type, TypeParameter  typeparam) {
        super(line, column, TypesEx.PARAMETER);
        this.id = id;
        this.type = RetornarTipos.RetornarTipos(type);
        this.typeparam = typeparam;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        if(this.typeparam == TypeParameter.LIST || this.typeparam == TypeParameter.VECTOR || this.typeparam == TypeParameter.VECTOR2){
            return new ReturnTypes(this.id, this.type);
        }
        else{
            return new ReturnTypes(this.id, this.type);
        }
    }
    
}
