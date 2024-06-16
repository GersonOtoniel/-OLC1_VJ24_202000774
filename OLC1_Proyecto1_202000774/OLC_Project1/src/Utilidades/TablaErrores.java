/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.util.LinkedList;

/**
 *
 * @author Gerson
 */
public class TablaErrores {
    public static LinkedList<Error> errores = new LinkedList<Error>();
    
    public static void push(Error error){
        errores.add(error);
    }
}
