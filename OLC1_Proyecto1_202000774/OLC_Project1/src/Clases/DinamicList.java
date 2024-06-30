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
public class DinamicList extends Instruccion{

    public String id;
    public Types type;
    public DinamicList(int linea, int columna, String id, String type) {
        super(linea, columna, TypesIns.DINAMICLIST);
        this.id = id;
        this.type = RetornarTipos.RetornarTipos(type);
    }

    @Override
    public Object ejecutar(Entorno env) {
        //env.saveDinamicList(this.id, new LinkedList<?>());
        env.saveDinamicList(this.linea, this.columna,this.id, new LinkedList<Object>(), this.type, "var");
        return null;
    }
    
}
