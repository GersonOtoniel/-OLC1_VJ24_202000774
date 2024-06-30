/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.RetornarTipos;
import Utilidades.TypesIns;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class Function extends Instruccion {

    public String id;
    public Types type;
    public Instruccion block;
    public LinkedList<Object> parametros;
    public Function(int linea, int columna, String id, String type, Instruccion block, LinkedList<Object> parametros) {
        super(linea, columna, TypesIns.FUNCTION);
        this.id = id;
        this.type = RetornarTipos.RetornarTipos(type);
        this.block = block;
        this.parametros = parametros;
    }

    @Override
    public Object ejecutar(Entorno env) {
        env.saveFunction(this.linea, this.columna,this.id, this);
        return null;
    }
    
}
