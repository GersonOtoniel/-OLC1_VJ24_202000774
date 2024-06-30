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
public class StructAccess  extends Expresion{

    public String id1;
    public String id2;
    public StructAccess(int line, int column, String id1, String id2) {
        super(line, column, TypesEx.STRUCT_ACCESS);
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
       
        Simbolo symbol = env.getValue(this.id1);
        //System.out.println(symbol);
        //System.out.println(symbol.value);
        for(var i = 0; i < ((LinkedList<?>)symbol.value).size(); i++){
            //System.out.println(((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).value);
            String val1 = ((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).id;
            String Thisval = this.id2;
            //System.out.println(((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).value);
            if(val1.equals(Thisval)){
                //System.out.println("coincidencia");
                return new ReturnTypes(((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).value, ((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).type);
            }
            //System.out.println(((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).id);
        }
        return null;
    }
    
}
