/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Utilidades.Salidas;
import Utilidades.Simbolo;
import Utilidades.TableSymbol;
import Utilidades.TypesIns;
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
    public Map<String, Function> functions = new HashMap<>();
    public Map<String, Struct> structs = new HashMap<>();
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
            ids.put(id.toLowerCase(), new Simbolo(id, value, type, TypesIns.VECTOR, mutabilidad));
           
            if(value instanceof LinkedList){
                TableSymbol.push(linea, columna, id, "Variable", this.getType(type), env.nombre.toString(), this.imprimirArray((LinkedList<?>)value), mutabilidad);
            }
            else if(value instanceof ArrayList){
                TableSymbol.push(linea, columna, id, "Variable", this.getType(type), env.nombre.toString(), this.imprimirArray2((ArrayList<?>)value), mutabilidad);
            }
            
            //para tabla de simbolos
        }
        else{
            //System.out.println("Error semantico el id de este array ya existe en este entorno");
            String errorVar = String.format("--> Error Semántico: El indentificador %s para esta lista o vector ya existe en este entorno.\n", id);
            Salidas.printConsola.add(errorVar);
            //Error
        }
    }
    
    
    public void saveDinamicList(int linea, int columna,String id, LinkedList<?> value, Types type, String mutabilidad){
        Entorno env = this;
        if(!env.ids.containsKey(id.toLowerCase())){
            ids.put(id.toLowerCase(), new Simbolo(id,value, type, TypesIns.DINAMICLIST, "ARRAY"));
            TableSymbol.push(linea, columna, id, "Variable", this.getType(type), env.nombre.toString(), this.imprimirArray(value), mutabilidad);
        }
        else{
            System.out.println("-->Error: Variable ya existe en el entorno actual");
            String errorVar = String.format("--> Error Semántico: El indentificador %s para esta lista o vector ya existe en este entorno.\n", id);
            Salidas.printConsola.add(errorVar);
            //Error
        }
    }
    
    
    public void saveFunction(int linea, int columna,String id, Function funcion){
        Entorno env = this;
        if(env.functions.containsKey(id.toLowerCase())){
            System.out.println("Error la funcionn ya existe en el entorno actual.");
            return;
        }
        else{
            env.functions.put(id.toLowerCase(), funcion);
            //System.out.println(env.functions);
            // A partir de aqui es para la tabla de simbolos-------------------------------------
            String typeFunc = this.getTypeFunc(funcion.type);
            TableSymbol.push(linea, columna, id, "Variable", typeFunc, env.nombre.toString(), typeFunc, "Funcion");
            // Aqui puedo ver si se guarda bien la funcion o metodo
            BloqueIns validate = (BloqueIns)funcion.block;
            LinkedList<Instruccion> instruccion = validate.instrucciones;
        }
    }
    
    
    public void saveStruct(String id, Struct strc){
        Entorno env = this;
        if(env.structs.containsKey(id.toLowerCase())){
            //System.out.println("Error este struct ya existe en el entorno actual");
            String errorVar = String.format("--> Error Semántico: El indentificador %s para este Struct ya existe en este entorno.\n", id);
            Salidas.printConsola.add(errorVar);
            return;
        }
        else{
            env.structs.put(id.toLowerCase(), strc);
            //System.out.println(((ValStruct)((LinkedList<?>)env.structs.get(id.toLowerCase()).values).get(1)).type);
        }
    }
    
    
    public void append(String id, Object value){
        Entorno env = this;
        if(env.ids.containsKey(id.toLowerCase())){
            Simbolo list = ids.get(id.toLowerCase());
            //ReturnTypes temp = (ReturnTypes) value.value;
            //System.out.println(list.type + "---" + ((ReturnTypes)value).type);
            if(list.type != ((ReturnTypes)value).type){
                String errorVar = String.format("--> Error Semántico: El tipo %s de la variable no es igual que el tipo %s de la lista actual .\n", ((ReturnTypes)value).type, list.type);
                Salidas.printConsola.add(errorVar);
                //System.out.println("-->Error semántico: el tipo que se esta agregando no es igual al tipo de la lista");
                
            }
            else{
                ((LinkedList<ReturnTypes>)list.value).add((ReturnTypes) value);
                //System.out.println(((Primitive)((LinkedList<?>)list.value).get(0)).type);
                //System.out.println(list.value);
            }    
        }
    }
    
    public ReturnTypes remove(String id, int i){
        Entorno env = this;
        if(env.ids.containsKey(id.toLowerCase())){
            Simbolo symbol = ids.get(id.toLowerCase());
            //System.out.println(i);
            if(i < 0 || i > ((LinkedList<?>)symbol.value).size()-1){
                //System.out.println("--> Error semantico: el indice esta fuera de rango");
                String errorVar = String.format("--> Error Semántico: El indice %s se encuentra fuera de rango.\n", i);
                Salidas.printConsola.add(errorVar);
                return new ReturnTypes("NULL", Types.NULL);
            }
            else{
                ReturnTypes value = (ReturnTypes) ((LinkedList<?>)symbol.value).remove(i);
                return new ReturnTypes(value.value, value.type);
            }
        }
        return null;
    }
    
    public Boolean check(String id, ReturnTypes value){
        
        Entorno env = this;
        while(env != null){
        if(env.ids.get(id.toLowerCase())!=null){
            Simbolo symbol = env.ids.get(id.toLowerCase());
            if(symbol.type != value.type){
                
                String errorTipo = String.format("--> Error Semántico: No se le puede asignar %s a %s \n", value.type, symbol.type);
                Salidas.printConsola.add(errorTipo);
                return true;
            }
            else if("const".equals(symbol.mutabilidad)){
                    String errorContante = "--> Error Semantico: Variable de tipo constante no puede ser reasignada\n";
                    Salidas.printConsola.add(errorContante);
                    
                    return true;
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
                
                ReturnTypes temp = ((ReturnTypes)((LinkedList<?>)symbol.value).get(indice));
                
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
                    //System.out.println("Error: la variable no es del mismo tipo que el valor");
                    String errorVar = String.format("--> Error Semántico: La variable %s no es del mismo tipo que el valor.\n", temp.value);
                    Salidas.printConsola.add(errorVar);
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
                    //System.out.println("Error: Variable y valor no son del mismo tipo");
                    String errorVar = String.format("--> Error Semántico: La variable %s y el valor no son del mismo tipo.\n", ((ReturnTypes)((ArrayList<?>)temp.value).get(j)).type);
                    Salidas.printConsola.add(errorVar);
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
    
    
    public Boolean reasignStruct(String id, String atr, Primitive value){
        Entorno env = this;
        while(env!=null){
            if(env.ids.containsKey(id.toLowerCase())){
                
                Simbolo symbol = env.ids.get(id.toLowerCase());
                for(var i = 0; i < ((LinkedList<?>)symbol.value).size(); i++){
                    String val1 = ((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).id;
                    
                    if(val1.equals(atr)){
                        //System.out.println(value.value);
                        ((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).setValue(value.value);
                        return true;
                    }
                }
            }
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
    
    public Function getFunction(String id){
        Entorno env = this;
        while(env!=null){
            if(env.functions.containsKey(id.toLowerCase())){
                return env.functions.get(id.toLowerCase());
            }
            env = env.prev;
        }
        return null;
    }
    
    public Struct getStruct(String id){
        Entorno env = this;
        while(env!=null){
            if(env.structs.containsKey(id.toLowerCase())){
                return env.structs.get(id.toLowerCase());
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
    
    
    public String getTypeFunc(Types type){
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
        return "void";
    }
    
    
    public String imprimirArray(LinkedList<?> values){
        
        String resultado = "[ ";
        for(var i = 0; i< values.size(); i++){
            ReturnTypes dato = ((ReturnTypes) values.get(i));
           
            resultado+=dato.value;
            if(i == values.size()-1){
                break;
            }
            resultado+=", ";
        }
        resultado+=" ]";
        return resultado;
    }
    
    public String imprimirArray2(ArrayList<?> values){
        
        String resultado = "[ ";
        String datos = "";
        for(var i = 0; i< values.size(); i++){
            ReturnTypes dato = ((ReturnTypes) values.get(i));
            
            if(dato.value instanceof ArrayList){
                datos = this.imprimirMiniArrays((ArrayList<?>) dato.value);
            }
            resultado+=datos;
            if(i == values.size()-1){
                break;
            }
            resultado+=", ";
        }
        resultado+=" ]";
        return resultado;
    }
    
    public String imprimirMiniArrays(ArrayList<?> values){
        String resultado = "[ ";
        
        for(var i = 0; i< values.size(); i++){
            ReturnTypes dato = ((ReturnTypes) values.get(i));
            resultado+=dato.value;
            if(i == values.size()-1){
                break;
            }
            resultado+=", ";
        }
        resultado+=" ]";
        return resultado;
    }
}
