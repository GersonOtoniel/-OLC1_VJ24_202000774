/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Utilidades.TypesIns;
import Utilidades.RetornarTipos;
import static Utilidades.RetornarTipos.RetornarTipos;
import Utilidades.Salidas;
/**
 *
 * @author Gerson
 */
public class Declaration extends Instruccion{
    public String id;
    public Types type;
    public Expresion value;
    public String mutabilidad;
    public Declaration(int fila, int columna, String id, String type, Expresion value, String mutabilidad){
        super(fila, columna, TypesIns.DECLARATION);
        this.id = id;
        this.type = RetornarTipos(type);
        this.value = value;
        this.mutabilidad = mutabilidad;
    }

    @Override
    public Object ejecutar(Entorno env) {
        
        if(this.value != null){
            ReturnTypes val = this.value.ejecutar(env);
     
            if(val.type != this.type){
                String errorTipo = String.format("--> Error Semántico: %s no es del mismo tipo que %s \n", val.type, this.type);
                Salidas.printConsola.add(errorTipo);
                return null;
            }
            env.saveID(linea, columna, this.id, type, val.value, mutabilidad);
            //aqui agrego a la tabla de simbolos
        }else{
            
            env.saveID(linea, columna, id, type, Default.getValueDefault(this.type), mutabilidad);
            //aqui asignio un valor por defecto
        }
        return null;
    }
}
