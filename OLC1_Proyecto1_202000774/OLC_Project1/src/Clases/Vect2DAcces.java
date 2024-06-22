/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.Simbolo;
import Utilidades.TypesEx;
import java.util.ArrayList;

/**
 *
 * @author Gerson
 */
public class Vect2DAcces extends Expresion{

    public String id;
    public Expresion index1;
    public Expresion index2;
    public Types type = Types.NULL;
    public Vect2DAcces(int line, int column, String id, Expresion index1, Expresion index2) {
        super(line, column, TypesEx.VECTORACCES);
        this.id = id;
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
        ReturnTypes i = this.index1.ejecutar(env);
        ReturnTypes j = this.index2.ejecutar(env);
        Simbolo value = env.getValueMatrix(this.id, (int)i.value, (int)j.value);
        if(value==null){
            System.out.println("Error: no se encontro el valor en el arreglo en la posicion i, j");
            return new ReturnTypes("NULL", Types.NULL);
        }
        this.type = ((ReturnTypes)((ArrayList<?>)((ReturnTypes)((ArrayList<?>)value.value).get((int)i.value)).value).get((int)j.value)).type;
        ReturnTypes valor = ((ReturnTypes)((ArrayList<?>)((ReturnTypes)((ArrayList<?>)value.value).get((int)i.value)).value).get((int)j.value));
        
        //System.out.println(this.type);
        return new ReturnTypes(valor.value, this.type);
    }
    
}
