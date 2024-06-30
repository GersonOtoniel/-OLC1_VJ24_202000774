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
public class AsignStruct extends Instruccion{

    public String id;
    public String atributo;
    public Expresion value;
    public AsignStruct(int linea, int columna, String id, String atributo, Expresion value) {
        super(linea, columna, TypesIns.ASIGN_STRUCT);
        this.id = id;
        this.atributo = atributo;
        this.value = value;
    }

    @Override
    public Object ejecutar(Entorno env) {
        ReturnTypes value = this.value.ejecutar(env);
        Primitive primitive = new Primitive(this.linea, this.columna, value.value, value.type);
        env.reasignStruct(this.id, this.atributo, primitive);
        return null;
    }
    
}
