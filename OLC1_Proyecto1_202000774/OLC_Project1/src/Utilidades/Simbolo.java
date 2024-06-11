/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Clases.Entorno;
import Clases.Types;

/**
 *
 * @author Gerson
 */
public class Simbolo {
    public String id;
    public Object value;
    public Types type;
    public Entorno env;
    public Simbolo(String id, Object value, Types type){
        this.id = id;
        this.value = value;
        this.type = type;
        //this.env = env;
    }
    
}
