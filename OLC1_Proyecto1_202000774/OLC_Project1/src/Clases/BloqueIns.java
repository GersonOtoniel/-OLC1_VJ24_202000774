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
        //System.out.println(env.nombre);
        String entorno = "Bloque If";
        Entorno bloqueEntorno = new Entorno(env,entorno);
        for(var instruccion : this.instrucciones){
            try{
                var retorno = instruccion.ejecutar(bloqueEntorno);
                if(retorno != null && !(instruccion instanceof IncDecIns)){
                    return retorno;
                }
            }catch(Exception e){}
        }
        return null;
    }
    
}
