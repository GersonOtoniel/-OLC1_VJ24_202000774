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
public class BloqueIns extends Instruccion{

    public LinkedList<Instruccion> instrucciones;
    public BloqueIns(int linea, int columna, LinkedList<Instruccion> instrucciones) {
        super(linea, columna, TypesIns.BLOQUEINS);
        this.instrucciones = instrucciones;
    }

    @Override
    public Object ejecutar(Entorno env) {
        //System.out.println(this.instrucciones);
        String entorno = env.nombre.toString();
        Entorno bloqueEntorno = new Entorno(env,entorno);
        for(var instruccion : this.instrucciones){
           
            try{
                //aqui si retorna algo es que se realizo un calculo u operacion
                var retorno = instruccion.ejecutar(bloqueEntorno);//Tipo ReturnTupes
                //System.out.println(((ReturnTypes)retorno).type);
                //System.out.println(instruccion);
                if(retorno != null && !(instruccion instanceof IncDecIns)){
                    //System.out.println("entra en un if del bloqueins--" + ((ReturnTypes)retorno).type + "--" + instruccion);
                    return retorno;
                }
            }catch(Exception e){}
        }
        return null;
    }
    
}
