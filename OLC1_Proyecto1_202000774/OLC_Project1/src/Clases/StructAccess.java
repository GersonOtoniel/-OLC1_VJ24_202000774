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
    public LinkedList<Object> ids;
    public StructAccess(int line, int column, String id1, String id2, String id3) {
        super(line, column, TypesEx.STRUCT_ACCESS);
        this.id1 = id1;
        this.id2 = id2;
        this.ids = ids;
    }

    @Override
    public ReturnTypes ejecutar(Entorno env) {
       
        Simbolo symbol = env.getValue(this.id1);
//-------------------------------------------------------------------------------------------------------------------        
       /* int contador = 0;
        if(this.ids != null){
            while(contador < this.ids.size()){
                
                Simbolo retorno = (Simbolo) this.returnStruct((String) this.ids.get(contador), env);
                
               
                if(retorno.value instanceof LinkedList){
                    for(var i = 0; i < ((LinkedList<?>)retorno.value).size(); i++){
                        if(((LinkedList<?>)retorno.value).get(i) instanceof ValorStruct){
                            //asdf
                        }
                        String val1 = ((ReturnStructTypes)((LinkedList<?>)retorno.value).get(i)).id;
                        String Thisval = this.id2;
                        
                    }
                }
            }
        }*/
//------------------------------------------------------------------------------------------------------
        for(var i = 0; i < ((LinkedList<?>)symbol.value).size(); i++){
            //System.out.println(((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).value);
            String val1 = ((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).id;
            String Thisval = this.id2;
            //System.out.println(((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).value);
            if(val1.equals(Thisval)){
                
                return new ReturnTypes(((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).value, ((ReturnTypes)((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).value).type);
            }
            //System.out.println(((ReturnStructTypes)((LinkedList<?>)symbol.value).get(i)).id);
        }
        return null;
//-----------------------------------------------------------------------------------------------------------        
    }
    
    
    public Object returnStruct(String id, Entorno env){
        Simbolo symb = env.getValue(id);
        return symb;
    }
    
    public Object returnValStruct(LinkedList<?> value){
        for(var i = 0; i < value.size(); i++){
            if(value.get(i) instanceof LinkedList){
                returnValStruct((LinkedList<?>) value.get(i));
            }
            else if(value.get(i) instanceof ReturnStructTypes){
                String val1 = ((ReturnStructTypes)value.get(i)).id;
            }
        }
        return null;
    }
    
}
