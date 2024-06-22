/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Utilidades.Salidas;
import Utilidades.Simbolo;
import Utilidades.TableSymbol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
    
    public void saveArray(int linea, int columna, String id, Types type, Object value, String mutabilidad ){
        Entorno env = this;
        if(!env.ids.containsKey(id.toLowerCase())){
            ids.put(id.toLowerCase(), new Simbolo(id, value, Types.VECTOR, mutabilidad));
            //para tabla de simbolos
        }
        else{
            System.out.println("Error semantico el id de este array ya existe en este entorno");
            //Error
        }
    }
    
    
    public void saveDinamicList(String id, LinkedList<?> value){
        Entorno env = this;
        if(!env.ids.containsKey(id.toLowerCase())){
            ids.put(id.toLowerCase(), new Simbolo(id,value,Types.ARRAY, "ARRAY"));
        }
        else{
            System.out.println("-->Error: Variable ya existe en el entorno actual");
            //Error
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
    
    //pendiente de verificar
    public Boolean reasignValueArray(String id, int indice, Primitive value, Types type, String mutabilidad){
        Entorno env = this;
        while(env!=null){
            if(env.ids.containsKey(id.toLowerCase())){
                Simbolo symbol  = env.ids.get(id.toLowerCase());
                
                ReturnTypes temp = ((ReturnTypes)((ArrayList<?>)symbol.value).get(indice));
                
                if(temp.type == Types.ARRAY){
                    //((ReturnTypes)((ArrayList<?>)symbol.value).set(indice, value));
                    temp.setValue(value.value);
                    temp.setType(Types.ARRAY);
                    //((ReturnTypes)((ArrayList<?>)symbol.value).get(indice)).type = Types.ARRAY;
                    return true;
                }
                //((ReturnTypes)((ArrayList<?>)symbol.value).get(indice)).value = value;
                //((ReturnTypes)((ArrayList<?>)symbol.value).get(indice)).type = Types.ARRAY;
                if(temp.type!=value.type){
                    System.out.println("Error: la variable no es del mismo tipo que el valor");
                    return false;
                }
                temp.setValue(value.value);
                temp.setType(value.type);
                env.ids.put(id.toLowerCase(), symbol);
                 return true;
                
            }
            env = env.prev;
        }
        return false;
    }
    
    
    
    public Simbolo getValueMatrix(String id, int index1, int index2){
        Entorno env = this;
        
        while(env!=null){
            if(env.ids.containsKey(id.toLowerCase())){
                Simbolo symbol = env.ids.get(id.toLowerCase());
                ReturnTypes temp = (ReturnTypes) ((ArrayList<?>)symbol.value).get(index1);
                if(((ArrayList<?>)temp.value).get(index2)==null){
                    return null;
                }
                //((ArrayList<?>)temp.value).get(index2)
                return  (Simbolo) symbol;
            }
            
            env = env.prev;
        }
        return null;
    }
    
    public Boolean reasingValueMatrix(String id, int i, int j, Primitive value){
        Entorno env = this;
        while(env!=null){
            if(env.ids.containsKey(id.toLowerCase())){
                Simbolo symbol = env.ids.get(id.toLowerCase());
                ReturnTypes temp = (ReturnTypes)(((ArrayList<?>)symbol.value).get(i));
                if(((ReturnTypes)((ArrayList<?>)temp.value).get(j)).type != value.type){
                    System.out.println("Error: Variable y valor no son del mismo tipo");
                    return false;
                }
                ((ReturnTypes)((ArrayList<?>)temp.value).get(j)).setValue(((ReturnTypes)value.value).value);
                
                ((ReturnTypes)((ArrayList<?>)temp.value).get(j)).setType(((ReturnTypes)value.value).type);
                //System.out.println(((ReturnTypes)value.value).type);
                //System.out.println(((ReturnTypes)((ArrayList<?>)temp.value).get(j)).value);
                
                env.ids.put(id.toLowerCase(), symbol);
                return true;
            }
            env = env.prev;
        }
        return null;
    }
    
    public Simbolo getValueArray(String id){
        Entorno env = this;
        while(env!=null){
            if(env.ids.containsKey(id.toLowerCase())){
                Simbolo simbolo = env.ids.get(id.toLowerCase());
                //System.out.println(((ReturnTypes)((ArrayList<?>)simbolo.value).get(indice)).value);
                
                return   simbolo ;
            }
            env = env.prev;
        }
        return null;
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
