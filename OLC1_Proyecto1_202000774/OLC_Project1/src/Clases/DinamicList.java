/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class DinamicList extends Instruccion{

    public String id;
    public String type;
    public DinamicList(int linea, int columna, String id, String type) {
        super(linea, columna, TypesIns.DINAMICLIST);
        this.id = id;
        this.type = type;
    }

    @Override
    public Object ejecutar(Entorno env) {
        env.saveDinamicList(this.id, new LinkedList<?>());
        return null;
    }
    
}
