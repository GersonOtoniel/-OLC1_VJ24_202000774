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
public class Nodo {
    public Object dato;
    public Nodo siguiente;
    public Nodo(Object dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
}
