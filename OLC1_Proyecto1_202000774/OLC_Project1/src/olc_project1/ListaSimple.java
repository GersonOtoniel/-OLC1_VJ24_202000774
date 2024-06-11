/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olc_project1;

import javacup.Simbol;

/**
 *
 * @author Gerson
 */
public class ListaSimple {
    
    public Nodo cabeza;
    public int tamaño;
    
    public ListaSimple(){
        this.cabeza = null;
        this.tamaño = 0;
    }
    
    public void add(Object nodo){
        Nodo nuevo = new Nodo(nodo);
        if(cabeza==null | tamaño==0){
            cabeza = nuevo;
            tamaño+=1;
        }else{
            Nodo actual = cabeza;
            while(actual.siguiente!=null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        tamaño+=1;
        }
    }
}
