/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Utilidades.Salidas;
import Utilidades.Simbolo;
import Utilidades.TableSymbol;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gerson
 */
public class Entorno {
    public Map<String, Simbolo> ids = new HashMap<>();
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
    
    public void saveID(int linea, int columna, String id, Types type, Object value, String mutabilidad){
        Entorno env = this;
        //System.out.println(env.ids.containsKey(id));
        if(!env.ids.containsKey(id)){
            ids.put(id.toLowerCase(), new Simbolo(id, value, type, mutabilidad));//aqui se agreaga a la tabla de simbolos
            TableSymbol.push(linea, columna, id, "Variable", this.getType(type), env.nombre.toString(), value.toString(), mutabilidad);
            
        }else{
            String errorVar = String.format("--> Error Semántico: El identificador %s ya existe en este entorno.\n", id);
            Salidas.printConsola.add(errorVar);
        }
    }
    
    public Boolean check(String id, ReturnTypes value){
        
        Entorno env = this;
        while(env != null){
        if(env.ids.get(id.toLowerCase())!=null){
            Simbolo symbol = env.ids.get(id.toLowerCase());
            if(symbol.type != value.type){
                
                String errorTipo = String.format("--> Error Semántico: No se le puede asignar %s a %s \n", value.type, symbol.type);
                Salidas.printConsola.add(errorTipo);
                return false;
            }
            else if("const".equals(symbol.mutabilidad)){
                    String errorContante = "--> Error Semantico: Variable de tipo constante no puede ser reasignada\n";
                    Salidas.printConsola.add(errorContante);
                    
                    return false;
            }
            symbol.value = value.value;
            env.ids.put(id.toLowerCase(), symbol);
            return true;
        }
        env = env.prev;
        }
        return false;
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
    
    public String getType(Types type){
        if(type == Types.BOOL){
            return "bool";
        }
        else if(type == Types.CHAR){
            return "char";
        }
        else if(type == Types.DECIMAL){
            return "double";
        }
        else if(type == Types.INT){
            return "int";
        }
        else if(type == Types.STRING){
            return "String";
        }
        return "NULL";
    }
}
