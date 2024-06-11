/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Utilidades.Salidas;
import Utilidades.Simbolo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gerson
 */
public class Entorno {
    public Map<String, Object> ids = new HashMap<>();
    public Entorno prev;
    public String nombre;
    
    public Entorno(Entorno prev, String nombre){
        this.prev = prev;
        this.nombre = nombre;
    }

    public Entorno getPrev() {
        return prev;
    }

    public void setPrev(Entorno prev) {
        this.prev = prev;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPrint(Object value){
        Salidas.printConsola.add(value);
    }
    
    public void saveID(int linea, int columna, String id, Types type, Object value){
        Entorno env = this;
        //System.out.println(env.ids.containsKey(id));
        if(!env.ids.containsKey(id)){
            ids.put(id.toLowerCase(), new Simbolo(id, value, type));//aqui se agreaga a la tabla de simbolos
        }else{
            System.out.println("Esta variable ya existe");//AQUI VA UN ERROR SEMANTICO
        }
    }
    
    public Simbolo getValue(String id){
        Entorno env = this;
        
        while(env != null){
            if(env.ids.get(id.toLowerCase())!= null){
                return (Simbolo) env.ids.get(id.toLowerCase());
            }
            env = env.prev;
        }
        return null;
    }
}
