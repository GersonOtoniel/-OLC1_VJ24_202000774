/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Simbolo;
import Utilidades.TypesEx;
import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class RemoveEx extends Expresion {

    public String id;
    public Expresion index;
    public RemoveEx(int line, int column, String id, Expresion index) {
        super(line, column, TypesEx.REMOVEEX);
        this.id = id;
        this.index = index;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        ReturnTypes indice = this.index.ejecutar(env);
        ReturnTypes value = env.remove(this.id, (int)indice.value);
        
        return new ReturnTypes(value.value, value.type);
    }
    
}
