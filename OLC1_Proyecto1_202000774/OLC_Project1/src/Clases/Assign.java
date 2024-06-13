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
public class Assign extends Instruccion {
    
    public String id;
    public Expresion value;
    public Assign(int linea, int columna, String id, Expresion value) {
        super(linea, columna, TypesIns.ASSIGN);
        this.id = id;
        this.value = value;
    }

    @Override
    public Object ejecutar(Entorno env) {
        ReturnTypes val = this.value.ejecutar(env);
        
        Boolean respuesta = env.check(this.id, val);
        
        if(!respuesta){
            System.out.println("no hay");//AQUI VA ERROR
        }
        return null;
    }
    
}
