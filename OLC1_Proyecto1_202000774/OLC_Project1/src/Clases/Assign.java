/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;
import Utilidades.RetornarTipos;
import static Utilidades.RetornarTipos.RetornarTipos;
/**
 *
 * @author Gerson
 */
public class Assign extends Instruccion{
    public String id;
    public Types type;
    public Expresion value;
    public Assign(int fila, int columna, String id, String type, Expresion value){
        super(fila, columna, TypesIns.ASSIGN);
        this.id = id;
        this.type = RetornarTipos(type);
        this.value = value;
    }

    @Override
    public Object ejecutar(Entorno env) {
        if(this.value != null){
            ReturnTypes val = this.value.ejecutar(env);
            //System.out.println(val.type);
            //System.out.println(type);
            //env.saveID(linea, columna, this.id, this.type, this.value);
            if(val.type != this.type){
                System.out.println("Error semantico no son del mismo tipo");//Error
                return null;
            }
            env.saveID(linea, columna, this.id, type, val.value);
            //aqui agrego a la tabla de simbolos
        }else{
            //aqui asignio un valor por defecto
        }
        return null;
    }
}
